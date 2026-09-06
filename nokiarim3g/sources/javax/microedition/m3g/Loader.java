package javax.microedition.m3g;

import com.sun.midp.midletsuite.InvalidJadException;
import java.p003io.ByteArrayInputStream;
import java.p003io.IOException;
import java.p003io.InputStream;
import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.lcdui.Image;
import javax.microedition.p004io.Connector;
import javax.microedition.p004io.HttpConnection;
import javax.microedition.p004io.InputConnection;
import javax.microedition.pki.CertificateException;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class Loader {
    private static final int INVALID_HEADER_TYPE = 0;
    private static final int M3G_TYPE = 1;
    private static final int MAX_IDENTIFIER_LENGTH = 12;
    private static final int PNG_TYPE = 2;
    private Vector iAnimTracks;
    private boolean iContainedExternalLinks;
    private int iCurrentSection;
    private boolean iExternalLinks;
    private Vector iFileHistory;
    private Vector iLoadedObjects;
    private Vector iLoadedObjectsRef;
    private String iParentResourceName;
    private String iResourceName;
    private long iTotalFileSize;
    static final byte[] M3G_FILE_IDENTIFIER = {-85, 74, 83, 82, 49, 56, 52, -69, CertificateException.UNSUPPORTED_PUBLIC_KEY_TYPE, 10, 26, 10};
    static final byte[] PNG_FILE_IDENTIFIER = {-119, 80, 78, 71, CertificateException.UNSUPPORTED_PUBLIC_KEY_TYPE, 10, 26, 10};
    static final boolean DEBUG = false;
    private static final Boolean NOT_REFERENCED = new Boolean(DEBUG);
    private static final Boolean REFERENCED = new Boolean(true);

    class AdlerInputStream extends CountedInputStream {
        static final int ADLER_CONST = 65521;
        private int iS1;
        private int iS2;
        private final Loader this$0;

        AdlerInputStream(Loader loader, InputStream inputStream) {
            super(loader, inputStream);
            this.this$0 = loader;
            this.iS1 = 1;
            this.iS2 = 0;
        }

        public long getChecksum() {
            return (((long) this.iS2) << 16) + ((long) this.iS1);
        }

        @Override // javax.microedition.m3g.Loader.CountedInputStream, java.p003io.InputStream
        public int read() throws IOException {
            int i = super.read();
            this.iS1 = ((i < 0 ? i + 256 : i) + this.iS1) % ADLER_CONST;
            this.iS2 = (this.iS2 + this.iS1) % ADLER_CONST;
            return i;
        }
    }

    class CountedInputStream extends InputStream {
        private int iCounter;
        private InputStream iStream;
        private final Loader this$0;

        public CountedInputStream(Loader loader, InputStream inputStream) {
            this.this$0 = loader;
            this.iStream = inputStream;
            resetCounter();
        }

        @Override // java.p003io.InputStream
        public int available() throws IOException {
            return this.iStream.available();
        }

        @Override // java.p003io.InputStream
        public void close() throws IOException {
            this.iStream.close();
        }

        public int getCounter() {
            return this.iCounter;
        }

        @Override // java.p003io.InputStream
        public int read() throws IOException {
            this.iCounter++;
            return this.iStream.read();
        }

        public void resetCounter() {
            this.iCounter = 0;
        }
    }

    class PeekInputStream extends InputStream {
        private int iBuffered;
        private int iCounter;
        private int[] iPeekBuffer;
        private InputStream iStream;
        private final Loader this$0;

        PeekInputStream(Loader loader, InputStream inputStream, int i) {
            this.this$0 = loader;
            this.iStream = inputStream;
            this.iPeekBuffer = new int[i];
        }

        @Override // java.p003io.InputStream
        public int available() throws IOException {
            return this.iCounter < this.iBuffered ? (this.iBuffered - this.iCounter) + this.iStream.available() : this.iStream.available();
        }

        @Override // java.p003io.InputStream
        public void close() throws IOException {
            this.iStream.close();
        }

        @Override // java.p003io.InputStream
        public int read() throws IOException {
            if (this.iCounter < this.iBuffered) {
                int[] iArr = this.iPeekBuffer;
                int i = this.iCounter;
                this.iCounter = i + 1;
                return iArr[i];
            }
            int i2 = this.iStream.read();
            if (this.iBuffered < this.iPeekBuffer.length) {
                this.iPeekBuffer[this.iBuffered] = i2;
                this.iBuffered++;
            }
            this.iCounter++;
            return i2;
        }

        public void rewind() throws IOException {
            if (this.iCounter > this.iBuffered) {
                throw new IOException("Peek buffer overrun.");
            }
            this.iCounter = 0;
        }
    }

    private Loader() {
        this.iLoadedObjects = new Vector();
        this.iLoadedObjectsRef = new Vector();
        this.iFileHistory = new Vector();
        this.iAnimTracks = null;
    }

    private Loader(Vector vector, String str) {
        this.iLoadedObjects = new Vector();
        this.iLoadedObjectsRef = new Vector();
        this.iFileHistory = new Vector();
        this.iAnimTracks = null;
        this.iParentResourceName = str;
        this.iFileHistory = vector;
    }

    static native int _inflate(byte[] bArr, byte[] bArr2);

    private void addAnimTracks(Object3D object3D) {
        if (this.iAnimTracks == null || object3D == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.iAnimTracks.size()) {
                this.iAnimTracks = null;
                return;
            } else {
                object3D.addAnimationTrack((AnimationTrack) this.iAnimTracks.elementAt(i2));
                i = i2 + 1;
            }
        }
    }

    private void addLoaded(Object3D object3D) {
        if (object3D != null) {
            this.iLoadedObjects.addElement(object3D);
            this.iLoadedObjectsRef.addElement(NOT_REFERENCED);
        }
    }

    private static final void copyGroup(Group group, Group group2) {
        copyNode(group, group2);
        for (int childCount = group.getChildCount() - 1; childCount >= 0; childCount--) {
            Node child = group.getChild(childCount);
            group.removeChild(child);
            group2.addChild(child);
        }
    }

    private static final void copyMesh(Mesh mesh, Mesh mesh2) {
        copyNode(mesh, mesh2);
    }

    private static final void copyNode(Node node, Node node2) {
        copyTransformable(node, node2);
        node2.setAlphaFactor(node.getAlphaFactor());
        node2.setScope(node.getScope());
        node2.setPickingEnable(node.isPickingEnabled());
        node2.setRenderingEnable(node.isRenderingEnabled());
    }

    private static final void copyObject3D(Object3D object3D, Object3D object3D2) {
        object3D2.setUserObject(object3D.getUserObject());
        object3D2.setUserID(object3D.getUserID());
    }

    private static final void copyTransformable(Transformable transformable, Transformable transformable2) {
        copyObject3D(transformable, transformable2);
        float[] fArr = new float[4];
        Transform transform = new Transform();
        transformable.getTranslation(fArr);
        transformable2.setTranslation(fArr[0], fArr[1], fArr[2]);
        transformable.getScale(fArr);
        transformable2.setScale(fArr[0], fArr[1], fArr[2]);
        transformable.getOrientation(fArr);
        transformable2.setOrientation(fArr[0], fArr[1], fArr[2], fArr[3]);
        transformable.getTransform(transform);
        transformable2.setTransform(transform);
    }

    private InputStream getHttpInputStream(String str) throws IOException {
        String headerField;
        InputConnection inputConnection = (InputConnection) Connector.open(str);
        if (!(inputConnection instanceof HttpConnection) || (headerField = ((HttpConnection) inputConnection).getHeaderField("Content-Type")) == null || headerField.equals("application/m3g") || headerField.equals("image/png")) {
            return inputConnection.openInputStream();
        }
        throw new IOException(new StringBuffer().append("Wrong MIME type: ").append(headerField).toString());
    }

    private int getIdentifierType(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[12];
        inputStream.read(bArr);
        return getIdentifierType(bArr, 0);
    }

    private static int getIdentifierType(byte[] bArr, int i) {
        byte[] bArr2 = PNG_FILE_IDENTIFIER;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            if (bArr[i3 + i] != bArr2[i3]) {
                i2++;
            }
        }
        if (i2 == 0) {
            return 2;
        }
        byte[] bArr3 = M3G_FILE_IDENTIFIER;
        int i4 = 0;
        for (int i5 = 0; i5 < bArr3.length; i5++) {
            if (bArr[i5 + i] != bArr3[i5]) {
                i4++;
            }
        }
        return i4 == 0 ? 1 : 0;
    }

    private InputStream getInputStream(String str) throws IOException {
        if (str.indexOf(58) != -1) {
            return getHttpInputStream(str);
        }
        if (str.charAt(0) == '/') {
            return new Object().getClass().getResourceAsStream(str);
        }
        if (this.iParentResourceName == null) {
            throw new IOException("Relative URI.");
        }
        String string = new StringBuffer().append(this.iParentResourceName.substring(0, this.iParentResourceName.lastIndexOf(47) + 1)).append(str).toString();
        return string.charAt(0) == '/' ? new Object().getClass().getResourceAsStream(string) : getHttpInputStream(string);
    }

    private Object3D getLoaded(int i) {
        if (i == 0) {
            return null;
        }
        if (i < 2 || i - 2 >= this.iLoadedObjects.size()) {
            throw new IllegalArgumentException(new StringBuffer().append("Invalid reference index [").append(this.iResourceName).append("].").toString());
        }
        this.iLoadedObjectsRef.setElementAt(REFERENCED, i - 2);
        return (Object3D) this.iLoadedObjects.elementAt(i - 2);
    }

    private Object3D[] getUnreferencedObjects() {
        Vector vector = new Vector();
        for (int i = 0; i < this.iLoadedObjects.size(); i++) {
            if (this.iLoadedObjectsRef.elementAt(i) == NOT_REFERENCED) {
                vector.addElement(this.iLoadedObjects.elementAt(i));
            }
        }
        Object3D[] object3DArr = new Object3D[vector.size()];
        for (int i2 = 0; i2 < vector.size(); i2++) {
            object3DArr[i2] = (Object3D) vector.elementAt(i2);
        }
        return object3DArr;
    }

    private boolean inFileHistory(String str) {
        for (int i = 0; i < this.iFileHistory.size(); i++) {
            if (((String) this.iFileHistory.elementAt(i)).equals(str)) {
                return true;
            }
        }
        return DEBUG;
    }

    private static void inflate(byte[] bArr, byte[] bArr2) {
        _inflate(bArr, bArr2);
    }

    public static Object3D[] load(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException();
        }
        try {
            return new Loader().loadFromString(str);
        } catch (IOException e) {
            throw e;
        } catch (SecurityException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new IOException(new StringBuffer().append("Load error ").append(e3).toString());
        }
    }

    public static Object3D[] load(byte[] bArr, int i) throws IOException {
        if (bArr == null) {
            throw new NullPointerException();
        }
        try {
            return new Loader().loadFromByteArray(bArr, i);
        } catch (IOException e) {
            throw e;
        } catch (SecurityException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new IOException(new StringBuffer().append("Load error ").append(e3).toString());
        }
    }

    private Object3D[] loadFromByteArray(byte[] bArr, int i) throws IOException {
        if (bArr == null) {
            throw new NullPointerException("Resource byte array is null.");
        }
        return loadStream(new ByteArrayInputStream(bArr, i, bArr.length - i), getIdentifierType(bArr, i));
    }

    private Object3D[] loadFromString(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException();
        }
        if (inFileHistory(str)) {
            throw new IOException("Reference loop detected.");
        }
        this.iResourceName = str;
        this.iFileHistory.addElement(str);
        PeekInputStream peekInputStream = new PeekInputStream(this, getInputStream(str), 12);
        int identifierType = getIdentifierType(peekInputStream);
        peekInputStream.rewind();
        Object3D[] object3DArrLoadStream = loadStream(peekInputStream, identifierType);
        this.iFileHistory.removeElement(str);
        return object3DArrLoadStream;
    }

    private Object3D[] loadM3G(InputStream inputStream) throws IOException {
        inputStream.skip(M3G_FILE_IDENTIFIER.length);
        while (loadSection(inputStream)) {
            this.iCurrentSection++;
        }
        return getUnreferencedObjects();
    }

    private Object3D loadObject(CountedInputStream countedInputStream) throws IOException {
        int i = readByte(countedInputStream);
        long uInt32 = readUInt32(countedInputStream) + ((long) countedInputStream.getCounter());
        Object3D world = null;
        switch (i) {
            case 0:
                if (this.iCurrentSection != 0) {
                    throw new IOException(new StringBuffer().append("Header in wrong section [").append(this.iResourceName).append("].").toString());
                }
                readHeader(countedInputStream);
                break;
            case 1:
                world = readAnimationController(countedInputStream);
                break;
            case 2:
                world = readAnimationTrack(countedInputStream);
                break;
            case 3:
                world = readAppearance(countedInputStream);
                break;
            case 4:
                world = readBackGround(countedInputStream);
                break;
            case 5:
                world = readCamera(countedInputStream);
                break;
            case 6:
                world = readCompositingMode(countedInputStream);
                break;
            case 7:
                world = readFog(countedInputStream);
                break;
            case 8:
                world = readPolygonMode(countedInputStream);
                break;
            case 9:
                world = readGroup(countedInputStream);
                break;
            case 10:
                world = readImage2D(countedInputStream);
                break;
            case 11:
                world = readTriangleStripArray(countedInputStream);
                break;
            case 12:
                world = readLight(countedInputStream);
                break;
            case 13:
                world = readMaterial(countedInputStream);
                break;
            case 14:
                world = readMesh(countedInputStream);
                break;
            case InvalidJadException.MISSING_VERSION /* 15 */:
                world = readMorphingMesh(countedInputStream);
                break;
            case 16:
                world = readSkinnedMesh(countedInputStream);
                break;
            case InvalidJadException.OLD_VERSION /* 17 */:
                world = readTexture2D(countedInputStream);
                break;
            case InvalidJadException.MISSING_JAR_URL /* 18 */:
                world = readSprite3D(countedInputStream);
                break;
            case InvalidJadException.JAR_SERVER_NOT_FOUND /* 19 */:
                world = readKeyframeSequence(countedInputStream);
                break;
            case InvalidJadException.JAR_NOT_FOUND /* 20 */:
                world = readVertexArray(countedInputStream);
                break;
            case InvalidJadException.MISSING_JAR_SIZE /* 21 */:
                world = readVertexBuffer(countedInputStream);
                break;
            case 22:
                world = readWorld(countedInputStream);
                break;
            case 255:
                if (this.iCurrentSection != 1) {
                    throw new IOException(new StringBuffer().append("External reference in wrong section [").append(this.iResourceName).append("].").toString());
                }
                if (!this.iExternalLinks) {
                    throw new IOException(new StringBuffer().append("External links in self contained file [").append(this.iResourceName).append("].").toString());
                }
                String string = readString(countedInputStream);
                this.iContainedExternalLinks = true;
                world = new Loader(this.iFileHistory, this.iResourceName).loadFromString(string)[0];
                break;
            default:
                throw new IOException(new StringBuffer().append("Unrecognized object type ").append(i).append(" [").append(this.iResourceName).append("].").toString());
        }
        if (uInt32 != countedInputStream.getCounter()) {
            throw new IOException(new StringBuffer().append("Object length mismatch [").append(this.iResourceName).append("].").toString());
        }
        addAnimTracks(world);
        return world;
    }

    private Object3D[] loadPNG(InputStream inputStream) throws IOException {
        return new Object3D[]{new Image2D(99, Image.createImage(inputStream))};
    }

    private boolean loadSection(InputStream inputStream) throws IOException {
        CountedInputStream countedInputStream;
        if (this.iCurrentSection > 1 && this.iExternalLinks && !this.iContainedExternalLinks) {
            throw new IOException(new StringBuffer().append("No external sections [").append(this.iResourceName).append("].").toString());
        }
        AdlerInputStream adlerInputStream = new AdlerInputStream(this, inputStream);
        int i = readByte(adlerInputStream);
        if (i == -1) {
            return DEBUG;
        }
        if (this.iCurrentSection == 0 && i != 0) {
            throw new IOException(new StringBuffer().append("Compressed header [").append(this.iResourceName).append("].").toString());
        }
        long uInt32 = readUInt32(adlerInputStream);
        long uInt33 = readUInt32(adlerInputStream);
        if (i == 0) {
            if (uInt33 != uInt32 - 13) {
                throw new IOException(new StringBuffer().append("Section length mismatch [").append(this.iResourceName).append("].").toString());
            }
            countedInputStream = adlerInputStream;
        } else {
            if (i != 1) {
                throw new IOException(new StringBuffer().append("Unrecognized compression scheme [").append(this.iResourceName).append("].").toString());
            }
            byte[] bArr = new byte[((int) uInt32) - 13];
            adlerInputStream.read(bArr);
            byte[] bArr2 = new byte[(int) uInt33];
            inflate(bArr, bArr2);
            countedInputStream = new CountedInputStream(this, new ByteArrayInputStream(bArr2));
        }
        countedInputStream.resetCounter();
        while (countedInputStream.getCounter() < uInt33) {
            addLoaded(loadObject(countedInputStream));
        }
        if (countedInputStream.getCounter() != uInt33) {
            throw new IOException(new StringBuffer().append("Section length mismatch [").append(this.iResourceName).append("].").toString());
        }
        if (adlerInputStream.getChecksum() != readUInt32(adlerInputStream)) {
            throw new IOException(new StringBuffer().append("Checksum is wrong [").append(this.iResourceName).append("].").toString());
        }
        return true;
    }

    private Object3D[] loadStream(InputStream inputStream, int i) throws IOException {
        if (i == 1) {
            return loadM3G(inputStream);
        }
        if (i == 2) {
            return loadPNG(inputStream);
        }
        throw new IOException("File not recognized.");
    }

    private AnimationController readAnimationController(InputStream inputStream) throws IOException {
        AnimationController animationController = new AnimationController();
        readObject3DData(animationController, inputStream);
        float float32 = readFloat32(inputStream);
        float float33 = readFloat32(inputStream);
        animationController.setActiveInterval(readInt32(inputStream), readInt32(inputStream));
        float float34 = readFloat32(inputStream);
        int int32 = readInt32(inputStream);
        animationController.setPosition(float34, int32);
        animationController.setSpeed(float32, int32);
        animationController.setWeight(float33);
        return animationController;
    }

    private AnimationTrack readAnimationTrack(InputStream inputStream) throws IOException {
        AnimationController animationController = new AnimationController();
        readObject3DData(animationController, inputStream);
        KeyframeSequence keyframeSequence = (KeyframeSequence) readReference(inputStream);
        AnimationController animationController2 = (AnimationController) readReference(inputStream);
        AnimationTrack animationTrack = new AnimationTrack(keyframeSequence, (int) readUInt32(inputStream));
        copyObject3D(animationController, animationTrack);
        animationTrack.setController(animationController2);
        return animationTrack;
    }

    private Appearance readAppearance(InputStream inputStream) throws IOException {
        Appearance appearance = new Appearance();
        readObject3DData(appearance, inputStream);
        appearance.setLayer(readByte(inputStream));
        appearance.setCompositingMode((CompositingMode) readReference(inputStream));
        appearance.setFog((Fog) readReference(inputStream));
        appearance.setPolygonMode((PolygonMode) readReference(inputStream));
        appearance.setMaterial((Material) readReference(inputStream));
        int uInt32 = (int) readUInt32(inputStream);
        for (int i = 0; i < uInt32; i++) {
            Texture2D texture2D = (Texture2D) readReference(inputStream);
            if (texture2D == null) {
                throw new IOException("Null texture reference");
            }
            appearance.setTexture(i, texture2D);
        }
        return appearance;
    }

    private Background readBackGround(InputStream inputStream) throws IOException {
        Background background = new Background();
        readObject3DData(background, inputStream);
        background.setColor(readRGBA(inputStream));
        background.setImage((Image2D) readReference(inputStream));
        background.setImageMode(readByte(inputStream), readByte(inputStream));
        background.setCrop(readInt32(inputStream), readInt32(inputStream), readInt32(inputStream), readInt32(inputStream));
        background.setDepthClearEnable(readBoolean(inputStream));
        background.setColorClearEnable(readBoolean(inputStream));
        return background;
    }

    private static boolean readBoolean(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i == 0) {
            return DEBUG;
        }
        if (i != 1) {
            throw new IOException("Malformed boolean.");
        }
        return true;
    }

    private static final int readByte(InputStream inputStream) throws IOException {
        return inputStream.read();
    }

    private Camera readCamera(InputStream inputStream) throws IOException {
        Camera camera = new Camera();
        readNodeData(camera, inputStream);
        int i = readByte(inputStream);
        if (i == 48) {
            camera.setGeneric(readTransform(inputStream));
        } else if (i == 50) {
            camera.setPerspective(readFloat32(inputStream), readFloat32(inputStream), readFloat32(inputStream), readFloat32(inputStream));
        } else {
            if (i != 49) {
                throw new IOException(new StringBuffer().append("Projection type not recognized: ").append(i).append("[").append(this.iResourceName).append("].").toString());
            }
            camera.setParallel(readFloat32(inputStream), readFloat32(inputStream), readFloat32(inputStream), readFloat32(inputStream));
        }
        return camera;
    }

    private CompositingMode readCompositingMode(InputStream inputStream) throws IOException {
        CompositingMode compositingMode = new CompositingMode();
        readObject3DData(compositingMode, inputStream);
        compositingMode.setDepthTestEnable(readBoolean(inputStream));
        compositingMode.setDepthWriteEnable(readBoolean(inputStream));
        compositingMode.setColorWriteEnable(readBoolean(inputStream));
        compositingMode.setAlphaWriteEnable(readBoolean(inputStream));
        compositingMode.setBlending(readByte(inputStream));
        compositingMode.setAlphaThreshold(readByte(inputStream) / 255.0f);
        compositingMode.setDepthOffset(readFloat32(inputStream), readFloat32(inputStream));
        return compositingMode;
    }

    private static final float readFloat32(InputStream inputStream) throws IOException {
        int int32 = readInt32(inputStream);
        if ((int32 & 2139095040) == 2139095040 || int32 == Integer.MIN_VALUE || ((8388607 & int32) != 0 && (int32 & 2139095040) == 0)) {
            throw new IOException("Malformed float.");
        }
        return Float.intBitsToFloat(int32);
    }

    private Fog readFog(InputStream inputStream) throws IOException {
        Fog fog = new Fog();
        readObject3DData(fog, inputStream);
        fog.setColor(readRGB(inputStream));
        fog.setMode(readByte(inputStream));
        if (fog.getMode() == 80) {
            fog.setDensity(readFloat32(inputStream));
        } else if (fog.getMode() == 81) {
            fog.setLinear(readFloat32(inputStream), readFloat32(inputStream));
        }
        return fog;
    }

    private Group readGroup(InputStream inputStream) throws IOException {
        Group group = new Group();
        readGroupData(group, inputStream);
        return group;
    }

    private void readGroupData(Group group, InputStream inputStream) throws IOException {
        readNodeData(group, inputStream);
        int uInt32 = (int) readUInt32(inputStream);
        while (true) {
            int i = uInt32 - 1;
            if (uInt32 <= 0) {
                return;
            }
            group.addChild((Node) readReference(inputStream));
            uInt32 = i;
        }
    }

    private void readHeader(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[2];
        inputStream.read(bArr);
        this.iExternalLinks = readBoolean(inputStream);
        this.iTotalFileSize = readUInt32(inputStream);
        readUInt32(inputStream);
        if (bArr[0] != 1 || bArr[1] != 0) {
            throw new IOException(new StringBuffer().append("Invalid file version [").append(this.iResourceName).append("].").toString());
        }
        readString(inputStream);
    }

    private Image2D readImage2D(InputStream inputStream) throws IOException {
        Image2D image2D;
        AnimationController animationController = new AnimationController();
        readObject3DData(animationController, inputStream);
        int i = readByte(inputStream);
        boolean z = readBoolean(inputStream);
        int uInt32 = (int) readUInt32(inputStream);
        int uInt33 = (int) readUInt32(inputStream);
        if (z) {
            image2D = new Image2D(i, uInt32, uInt33);
        } else {
            byte[] bArr = new byte[(int) readUInt32(inputStream)];
            if (bArr.length > 0) {
                inputStream.read(bArr);
            }
            byte[] bArr2 = new byte[(int) readUInt32(inputStream)];
            inputStream.read(bArr2);
            image2D = bArr.length != 0 ? new Image2D(i, uInt32, uInt33, bArr2, bArr) : new Image2D(i, uInt32, uInt33, bArr2);
        }
        copyObject3D(animationController, image2D);
        return image2D;
    }

    private static final int readInt32(InputStream inputStream) throws IOException {
        return inputStream.read() + (inputStream.read() << 8) + (inputStream.read() << 16) + (inputStream.read() << 24);
    }

    private KeyframeSequence readKeyframeSequence(InputStream inputStream) throws IOException {
        AnimationController animationController = new AnimationController();
        readObject3DData(animationController, inputStream);
        int i = readByte(inputStream);
        int i2 = readByte(inputStream);
        int i3 = readByte(inputStream);
        int uInt32 = (int) readUInt32(inputStream);
        int uInt33 = (int) readUInt32(inputStream);
        int uInt34 = (int) readUInt32(inputStream);
        int uInt35 = (int) readUInt32(inputStream);
        int uInt36 = (int) readUInt32(inputStream);
        KeyframeSequence keyframeSequence = new KeyframeSequence(uInt36, uInt35, i);
        copyObject3D(animationController, keyframeSequence);
        keyframeSequence.setRepeatMode(i2);
        keyframeSequence.setDuration(uInt32);
        keyframeSequence.setValidRange(uInt33, uInt34);
        float[] fArr = new float[uInt35];
        if (i3 == 0) {
            for (int i4 = 0; i4 < uInt36; i4++) {
                int int32 = readInt32(inputStream);
                for (int i5 = 0; i5 < uInt35; i5++) {
                    fArr[i5] = readFloat32(inputStream);
                }
                keyframeSequence.setKeyframe(i4, int32, fArr);
            }
        } else {
            if (i3 != 1 && i3 != 2) {
                throw new IOException(new StringBuffer().append("Encoding not recognized: ").append(i3).append("[").append(this.iResourceName).append("].").toString());
            }
            float[] fArr2 = new float[uInt35];
            float[] fArr3 = new float[uInt35];
            for (int i6 = 0; i6 < uInt35; i6++) {
                fArr2[i6] = readFloat32(inputStream);
            }
            for (int i7 = 0; i7 < uInt35; i7++) {
                fArr3[i7] = readFloat32(inputStream);
            }
            for (int i8 = 0; i8 < uInt36; i8++) {
                int int33 = readInt32(inputStream);
                if (i3 == 1) {
                    for (int i9 = 0; i9 < uInt35; i9++) {
                        fArr[i9] = ((readByte(inputStream) * fArr3[i9]) / 255.0f) + fArr2[i9];
                    }
                } else {
                    for (int i10 = 0; i10 < uInt35; i10++) {
                        fArr[i10] = ((readUInt16(inputStream) * fArr3[i10]) / 65535.0f) + fArr2[i10];
                    }
                }
                keyframeSequence.setKeyframe(i8, int33, fArr);
            }
        }
        return keyframeSequence;
    }

    private Light readLight(InputStream inputStream) throws IOException {
        Light light = new Light();
        readNodeData(light, inputStream);
        light.setAttenuation(readFloat32(inputStream), readFloat32(inputStream), readFloat32(inputStream));
        light.setColor(readRGB(inputStream));
        light.setMode(readByte(inputStream));
        light.setIntensity(readFloat32(inputStream));
        light.setSpotAngle(readFloat32(inputStream));
        light.setSpotExponent(readFloat32(inputStream));
        return light;
    }

    private Material readMaterial(InputStream inputStream) throws IOException {
        Material material = new Material();
        readObject3DData(material, inputStream);
        material.setColor(1024, readRGB(inputStream));
        material.setColor(2048, readRGBA(inputStream));
        material.setColor(4096, readRGB(inputStream));
        material.setColor(8192, readRGB(inputStream));
        material.setShininess(readFloat32(inputStream));
        material.setVertexColorTrackingEnable(readBoolean(inputStream));
        return material;
    }

    private Mesh readMesh(InputStream inputStream) throws IOException {
        Group group = new Group();
        readNodeData(group, inputStream);
        VertexBuffer vertexBuffer = (VertexBuffer) readReference(inputStream);
        int uInt32 = (int) readUInt32(inputStream);
        IndexBuffer[] indexBufferArr = new IndexBuffer[uInt32];
        Appearance[] appearanceArr = new Appearance[uInt32];
        for (int i = 0; i < uInt32; i++) {
            indexBufferArr[i] = (IndexBuffer) readReference(inputStream);
            appearanceArr[i] = (Appearance) readReference(inputStream);
        }
        Mesh mesh = new Mesh(vertexBuffer, indexBufferArr, appearanceArr);
        copyNode(group, mesh);
        return mesh;
    }

    private MorphingMesh readMorphingMesh(InputStream inputStream) throws IOException {
        Mesh mesh = readMesh(inputStream);
        int uInt32 = (int) readUInt32(inputStream);
        VertexBuffer[] vertexBufferArr = new VertexBuffer[uInt32];
        float[] fArr = new float[uInt32];
        for (int i = 0; i < uInt32; i++) {
            vertexBufferArr[i] = (VertexBuffer) readReference(inputStream);
            fArr[i] = readFloat32(inputStream);
        }
        int submeshCount = mesh.getSubmeshCount();
        IndexBuffer[] indexBufferArr = new IndexBuffer[submeshCount];
        Appearance[] appearanceArr = new Appearance[submeshCount];
        for (int i2 = 0; i2 < submeshCount; i2++) {
            indexBufferArr[i2] = mesh.getIndexBuffer(i2);
            appearanceArr[i2] = mesh.getAppearance(i2);
        }
        MorphingMesh morphingMesh = new MorphingMesh(mesh.getVertexBuffer(), vertexBufferArr, indexBufferArr, appearanceArr);
        copyMesh(mesh, morphingMesh);
        morphingMesh.setWeights(fArr);
        return morphingMesh;
    }

    private void readNodeData(Node node, InputStream inputStream) throws IOException {
        readTransformableData(node, inputStream);
        node.setRenderingEnable(readBoolean(inputStream));
        node.setPickingEnable(readBoolean(inputStream));
        node.setAlphaFactor(readByte(inputStream) / 255.0f);
        node.setScope((int) readUInt32(inputStream));
        if (readBoolean(inputStream)) {
            node.setAlignment((Node) getLoaded((int) readUInt32(inputStream)), readByte(inputStream), (Node) getLoaded((int) readUInt32(inputStream)), readByte(inputStream));
        }
    }

    private void readObject3DData(Object3D object3D, InputStream inputStream) throws IOException {
        object3D.setUserID((int) readUInt32(inputStream));
        long uInt32 = readUInt32(inputStream);
        this.iAnimTracks = new Vector();
        while (true) {
            long j = uInt32 - 1;
            if (uInt32 <= 0) {
                Hashtable hashtable = new Hashtable();
                long uInt33 = readUInt32(inputStream);
                while (true) {
                    long j2 = uInt33 - 1;
                    if (uInt33 <= 0) {
                        object3D.setUserObject(hashtable);
                        return;
                    }
                    int uInt34 = (int) readUInt32(inputStream);
                    byte[] bArr = new byte[(int) readUInt32(inputStream)];
                    inputStream.read(bArr);
                    hashtable.put(new Integer(uInt34), bArr);
                    uInt33 = j2;
                }
            } else {
                AnimationTrack animationTrack = (AnimationTrack) readReference(inputStream);
                if (animationTrack == null) {
                    throw new NullPointerException();
                }
                this.iAnimTracks.addElement(animationTrack);
                uInt32 = j;
            }
        }
    }

    private PolygonMode readPolygonMode(InputStream inputStream) throws IOException {
        PolygonMode polygonMode = new PolygonMode();
        readObject3DData(polygonMode, inputStream);
        polygonMode.setCulling(readByte(inputStream));
        polygonMode.setShading(readByte(inputStream));
        polygonMode.setWinding(readByte(inputStream));
        polygonMode.setTwoSidedLightingEnable(readBoolean(inputStream));
        polygonMode.setLocalCameraLightingEnable(readBoolean(inputStream));
        polygonMode.setPerspectiveCorrectionEnable(readBoolean(inputStream));
        return polygonMode;
    }

    private static int readRGB(InputStream inputStream) throws IOException {
        return (inputStream.read() << 16) + (inputStream.read() << 8) + inputStream.read();
    }

    private static int readRGBA(InputStream inputStream) throws IOException {
        return (inputStream.read() << 16) + (inputStream.read() << 8) + inputStream.read() + (inputStream.read() << 24);
    }

    private Object3D readReference(InputStream inputStream) throws IOException {
        return getLoaded((int) readUInt32(inputStream));
    }

    private SkinnedMesh readSkinnedMesh(InputStream inputStream) throws IOException {
        Mesh mesh = readMesh(inputStream);
        Group group = (Group) readReference(inputStream);
        int submeshCount = mesh.getSubmeshCount();
        IndexBuffer[] indexBufferArr = new IndexBuffer[submeshCount];
        Appearance[] appearanceArr = new Appearance[submeshCount];
        for (int i = 0; i < submeshCount; i++) {
            indexBufferArr[i] = mesh.getIndexBuffer(i);
            appearanceArr[i] = mesh.getAppearance(i);
        }
        SkinnedMesh skinnedMesh = new SkinnedMesh(mesh.getVertexBuffer(), indexBufferArr, appearanceArr, group);
        copyMesh(mesh, skinnedMesh);
        int uInt32 = (int) readUInt32(inputStream);
        while (true) {
            int i2 = uInt32 - 1;
            if (uInt32 <= 0) {
                return skinnedMesh;
            }
            skinnedMesh.addTransform((Node) readReference(inputStream), readInt32(inputStream), (int) readUInt32(inputStream), (int) readUInt32(inputStream));
            uInt32 = i2;
        }
    }

    private Sprite3D readSprite3D(InputStream inputStream) throws IOException {
        Group group = new Group();
        readNodeData(group, inputStream);
        Sprite3D sprite3D = new Sprite3D(readBoolean(inputStream), (Image2D) readReference(inputStream), (Appearance) readReference(inputStream));
        copyNode(group, sprite3D);
        sprite3D.setCrop(readInt32(inputStream), readInt32(inputStream), readInt32(inputStream), readInt32(inputStream));
        return sprite3D;
    }

    private static String readString(InputStream inputStream) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        int i = inputStream.read();
        while (i != 0) {
            if ((i & 128) == 0) {
                stringBuffer.append((char) (i & 255));
            } else if ((i & Texture2D.FUNC_ADD) == 192) {
                int i2 = inputStream.read();
                if ((i2 & KeyframeSequence.CONSTANT) != 128) {
                    throw new IOException("Invalid UTF-8 string.");
                }
                stringBuffer.append((char) (((i & 31) << 6) | (i2 & 63)));
            } else {
                if ((i & Texture2D.WRAP_CLAMP) != 224) {
                    throw new IOException("Invalid UTF-8 string.");
                }
                int i3 = inputStream.read();
                int i4 = inputStream.read();
                if ((i3 & KeyframeSequence.CONSTANT) != 128 || (i4 & KeyframeSequence.CONSTANT) != 128) {
                    throw new IOException("Invalid UTF-8 string.");
                }
                stringBuffer.append((char) (((i & 15) << 12) | ((i3 & 63) << 6) | (i4 & 63)));
            }
            i = inputStream.read();
        }
        return stringBuffer.toString();
    }

    private Texture2D readTexture2D(InputStream inputStream) throws IOException {
        Group group = new Group();
        readTransformableData(group, inputStream);
        Texture2D texture2D = new Texture2D((Image2D) readReference(inputStream));
        copyTransformable(group, texture2D);
        texture2D.setBlendColor(readRGB(inputStream));
        texture2D.setBlending(readByte(inputStream));
        texture2D.setWrapping(readByte(inputStream), readByte(inputStream));
        texture2D.setFiltering(readByte(inputStream), readByte(inputStream));
        return texture2D;
    }

    private static final Transform readTransform(InputStream inputStream) throws IOException {
        Transform transform = new Transform();
        float[] fArr = new float[16];
        for (int i = 0; i < 16; i++) {
            fArr[i] = readFloat32(inputStream);
        }
        transform.set(fArr);
        return transform;
    }

    private void readTransformableData(Transformable transformable, InputStream inputStream) throws IOException {
        readObject3DData(transformable, inputStream);
        if (readBoolean(inputStream)) {
            transformable.setTranslation(readFloat32(inputStream), readFloat32(inputStream), readFloat32(inputStream));
            transformable.setScale(readFloat32(inputStream), readFloat32(inputStream), readFloat32(inputStream));
            transformable.setOrientation(readFloat32(inputStream), readFloat32(inputStream), readFloat32(inputStream), readFloat32(inputStream));
        }
        if (readBoolean(inputStream)) {
            transformable.setTransform(readTransform(inputStream));
        }
    }

    private TriangleStripArray readTriangleStripArray(InputStream inputStream) throws IOException {
        int uInt16;
        AnimationController animationController = new AnimationController();
        readObject3DData(animationController, inputStream);
        int i = readByte(inputStream);
        int[] iArr = null;
        switch (i) {
            case 0:
                uInt16 = (int) readUInt32(inputStream);
                break;
            case 1:
                uInt16 = readByte(inputStream);
                break;
            case 2:
                uInt16 = readUInt16(inputStream);
                break;
            case 128:
                int[] iArr2 = new int[(int) readUInt32(inputStream)];
                for (int i2 = 0; i2 < iArr2.length; i2++) {
                    iArr2[i2] = (int) readUInt32(inputStream);
                }
                iArr = iArr2;
                uInt16 = 0;
                break;
            case Light.DIRECTIONAL /* 129 */:
                int[] iArr3 = new int[(int) readUInt32(inputStream)];
                for (int i3 = 0; i3 < iArr3.length; i3++) {
                    iArr3[i3] = readByte(inputStream);
                }
                iArr = iArr3;
                uInt16 = 0;
                break;
            case Light.OMNI /* 130 */:
                int[] iArr4 = new int[(int) readUInt32(inputStream)];
                for (int i4 = 0; i4 < iArr4.length; i4++) {
                    iArr4[i4] = readUInt16(inputStream);
                }
                iArr = iArr4;
                uInt16 = 0;
                break;
            default:
                throw new IllegalArgumentException(new StringBuffer().append("Invalid TriangleStripArray encoding [").append(this.iResourceName).append("].").toString());
        }
        int[] iArr5 = new int[(int) readUInt32(inputStream)];
        for (int i5 = 0; i5 < iArr5.length; i5++) {
            iArr5[i5] = (int) readUInt32(inputStream);
        }
        TriangleStripArray triangleStripArray = (i == 0 || i == 1 || i == 2) ? new TriangleStripArray(uInt16, iArr5) : new TriangleStripArray(iArr, iArr5);
        copyObject3D(animationController, triangleStripArray);
        return triangleStripArray;
    }

    private static int readUInt16(InputStream inputStream) throws IOException {
        return inputStream.read() + (inputStream.read() << 8);
    }

    private static final long readUInt32(InputStream inputStream) throws IOException {
        return ((long) inputStream.read()) + (((long) inputStream.read()) << 8) + (((long) inputStream.read()) << 16) + (((long) inputStream.read()) << 24);
    }

    private VertexArray readVertexArray(InputStream inputStream) throws IOException {
        AnimationController animationController = new AnimationController();
        readObject3DData(animationController, inputStream);
        int i = readByte(inputStream);
        int i2 = readByte(inputStream);
        int i3 = readByte(inputStream);
        int uInt16 = readUInt16(inputStream);
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException(new StringBuffer().append("Invalid VertexArray encoding [").append(this.iResourceName).append("].").toString());
        }
        VertexArray vertexArray = new VertexArray(uInt16, i2, i);
        int[] iArr = new int[i2];
        if (i == 1) {
            byte[] bArr = new byte[i2];
            if (i3 == 0) {
                for (int i4 = 0; i4 < uInt16; i4++) {
                    for (int i5 = 0; i5 < i2; i5++) {
                        bArr[i5] = (byte) readByte(inputStream);
                        vertexArray.set(i4, 1, bArr);
                    }
                }
            } else {
                for (int i6 = 0; i6 < uInt16; i6++) {
                    for (int i7 = 0; i7 < i2; i7++) {
                        iArr[i7] = (byte) (iArr[i7] + ((byte) readByte(inputStream)));
                        bArr[i7] = (byte) iArr[i7];
                        vertexArray.set(i6, 1, bArr);
                    }
                }
            }
        } else {
            short[] sArr = new short[i2];
            if (i3 == 0) {
                for (int i8 = 0; i8 < uInt16; i8++) {
                    for (int i9 = 0; i9 < i2; i9++) {
                        sArr[i9] = (short) readUInt16(inputStream);
                        vertexArray.set(i8, 1, sArr);
                    }
                }
            } else {
                for (int i10 = 0; i10 < uInt16; i10++) {
                    for (int i11 = 0; i11 < i2; i11++) {
                        iArr[i11] = (short) (iArr[i11] + ((short) readUInt16(inputStream)));
                        sArr[i11] = (short) iArr[i11];
                        vertexArray.set(i10, 1, sArr);
                    }
                }
            }
        }
        copyObject3D(animationController, vertexArray);
        return vertexArray;
    }

    private VertexBuffer readVertexBuffer(InputStream inputStream) throws IOException {
        VertexBuffer vertexBuffer = new VertexBuffer();
        readObject3DData(vertexBuffer, inputStream);
        vertexBuffer.setDefaultColor(readRGBA(inputStream));
        VertexArray vertexArray = (VertexArray) readReference(inputStream);
        float[] fArr = new float[3];
        for (int i = 0; i < 3; i++) {
            fArr[i] = readFloat32(inputStream);
        }
        float float32 = readFloat32(inputStream);
        if (vertexArray != null) {
            vertexBuffer.setPositions(vertexArray, float32, fArr);
        }
        VertexArray vertexArray2 = (VertexArray) readReference(inputStream);
        if (vertexArray2 != null) {
            vertexBuffer.setNormals(vertexArray2);
        }
        VertexArray vertexArray3 = (VertexArray) readReference(inputStream);
        if (vertexArray3 != null) {
            vertexBuffer.setColors(vertexArray3);
        }
        int uInt32 = (int) readUInt32(inputStream);
        for (int i2 = 0; i2 < uInt32; i2++) {
            VertexArray vertexArray4 = (VertexArray) readReference(inputStream);
            if (vertexArray4 == null) {
                throw new IOException("Null texture vertex array");
            }
            for (int i3 = 0; i3 < 3; i3++) {
                fArr[i3] = readFloat32(inputStream);
            }
            vertexBuffer.setTexCoords(i2, vertexArray4, readFloat32(inputStream), fArr);
        }
        return vertexBuffer;
    }

    private World readWorld(InputStream inputStream) throws IOException {
        World world = new World();
        readGroupData(world, inputStream);
        Camera camera = (Camera) readReference(inputStream);
        if (camera != null) {
            world.setActiveCamera(camera);
        }
        world.setBackground((Background) readReference(inputStream));
        return world;
    }

    static final byte trace(byte b) {
        System.out.println(new StringBuffer().append("").append((int) b).toString());
        return b;
    }

    static final float trace(float f) {
        System.out.println(new StringBuffer().append("").append(f).toString());
        return f;
    }

    static final int trace(int i) {
        System.out.println(new StringBuffer().append("").append(i).toString());
        return i;
    }

    static final long trace(long j) {
        System.out.println(new StringBuffer().append("").append(j).toString());
        return j;
    }

    static final void trace(String str) {
        System.out.println(str);
    }

    static final boolean trace(boolean z) {
        System.out.println(z ? "true" : "false");
        return z;
    }
}
