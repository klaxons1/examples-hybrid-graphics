package p000;

import javax.microedition.m3g.Appearance;
import javax.microedition.m3g.CompositingMode;
import javax.microedition.m3g.Group;
import javax.microedition.m3g.KeyframeSequence;
import javax.microedition.m3g.Loader;
import javax.microedition.m3g.Material;
import javax.microedition.m3g.Mesh;
import javax.microedition.m3g.Node;
import javax.microedition.m3g.PolygonMode;
import javax.microedition.m3g.Texture2D;
import javax.microedition.m3g.Transform;
import javax.microedition.m3g.World;

/* JADX INFO: renamed from: d */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0067d extends AbstractC0048bu {

    /* JADX INFO: renamed from: a */
    private static CompositingMode f455a;

    /* JADX INFO: renamed from: a */
    private static PolygonMode f456a;

    /* JADX INFO: renamed from: a */
    private static Transform f457a = new Transform();

    /* JADX INFO: renamed from: a */
    private static float[] f458a = new float[16];

    /* JADX INFO: renamed from: b */
    private static PolygonMode f459b;

    /* JADX INFO: renamed from: a */
    private byte f460a;

    /* JADX INFO: renamed from: a */
    private long f461a;

    /* JADX INFO: renamed from: a */
    private Node[] f462a;

    /* JADX INFO: renamed from: b */
    private Node[] f463b;

    /* JADX INFO: renamed from: c */
    private int f464c;

    /* JADX INFO: renamed from: d */
    private int f465d;

    /* JADX INFO: renamed from: d */
    private boolean f466d;

    /* JADX INFO: renamed from: e */
    private int f467e;

    /* JADX INFO: renamed from: f */
    private int f468f;

    private C0067d(C0067d c0067d) {
        super(new StringBuffer().append(((AbstractC0023aw) c0067d).f258a).append("Copy").toString());
        m220d();
        ((AbstractC0043bp) this).f374b = ((AbstractC0043bp) c0067d).f374b;
        this.f462a = c0067d.f462a;
        this.f463b = c0067d.f463b;
        ((AbstractC0048bu) this).f388a = ((AbstractC0048bu) c0067d).f388a;
        ((AbstractC0023aw) this).f259a = ((AbstractC0023aw) c0067d).f259a;
        this.f464c = c0067d.f464c;
        this.f465d = c0067d.f465d;
        this.f467e = c0067d.f467e;
        this.f468f = c0067d.f468f;
        this.f461a = c0067d.f461a;
        this.f466d = c0067d.f466d;
        this.f460a = c0067d.f460a;
    }

    public C0067d(String str, String str2, int i) {
        super(str);
        m220d();
        m216a(str2);
        ((AbstractC0043bp) this).f374b = i;
    }

    /* JADX INFO: renamed from: a */
    private int m215a(Node node, int i) {
        for (int i2 = 0; i2 < node.getAnimationTrackCount(); i2++) {
            KeyframeSequence keyframeSequence = node.getAnimationTrack(i2).getKeyframeSequence();
            if (keyframeSequence.getDuration() > i) {
                i = keyframeSequence.getDuration();
            }
        }
        if (node instanceof Group) {
            for (int i3 = 0; i3 < ((Group) node).getChildCount(); i3++) {
                Group child = ((Group) node).getChild(i3);
                for (int i4 = 0; i4 < child.getAnimationTrackCount(); i4++) {
                    KeyframeSequence keyframeSequence2 = child.getAnimationTrack(i4).getKeyframeSequence();
                    if (keyframeSequence2.getDuration() > i) {
                        i = keyframeSequence2.getDuration();
                    }
                }
                if (child instanceof Group) {
                    i = m215a((Node) child, i);
                }
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    private void m216a(String str) {
        try {
            World[] worldArrLoad = Loader.load(new StringBuffer().append(str).append(".m3g").toString());
            for (int i = 0; i < worldArrLoad.length; i++) {
                if (worldArrLoad[i] instanceof World) {
                    for (int i2 = 0; i2 < worldArrLoad[i].getChildCount(); i2++) {
                        Group child = worldArrLoad[i].getChild(i2);
                        int iM215a = m215a((Node) child, 0);
                        if (child instanceof Group) {
                            if (iM215a == 0) {
                                for (int i3 = 0; i3 < child.getChildCount(); i3++) {
                                    Node child2 = child.getChild(i3);
                                    if (child2 instanceof Mesh) {
                                        Transform transform = new Transform();
                                        child2.getCompositeTransform(transform);
                                        child.removeChild(child2);
                                        child2.setTransform(transform);
                                        m217a(child2);
                                    }
                                }
                            } else {
                                m217a((Node) child);
                                if (this.f464c >= iM215a) {
                                    iM215a = this.f464c;
                                }
                                this.f464c = iM215a;
                            }
                        } else if (child instanceof Mesh) {
                            m217a((Node) child);
                            if (this.f464c >= iM215a) {
                                iM215a = this.f464c;
                            }
                            this.f464c = iM215a;
                        }
                    }
                } else if (worldArrLoad[i] instanceof Group) {
                    int iM215a2 = m215a((Node) worldArrLoad[i], 0);
                    if (iM215a2 == 0) {
                        for (int i4 = 0; i4 < ((Group) worldArrLoad[i]).getChildCount(); i4++) {
                            Node child3 = ((Group) worldArrLoad[i]).getChild(i4);
                            if (child3 instanceof Mesh) {
                                Transform transform2 = new Transform();
                                child3.getCompositeTransform(transform2);
                                ((Group) worldArrLoad[i]).removeChild(child3);
                                child3.setTransform(transform2);
                                m217a(child3);
                            }
                        }
                    } else {
                        m217a((Node) worldArrLoad[i]);
                        this.f464c = this.f464c < iM215a2 ? iM215a2 : this.f464c;
                    }
                }
            }
            if (this.f464c != 0) {
                this.f465d = 0;
                this.f467e = this.f464c;
                this.f468f = 0;
                this.f461a = -1L;
                this.f466d = true;
                this.f460a = (byte) 2;
            }
        } catch (Exception e) {
            this.f462a = null;
            this.f463b = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m217a(Node node) {
        if (m219a(node)) {
            if (this.f463b == null) {
                this.f463b = new Node[1];
                this.f463b[0] = node;
                return;
            } else {
                Node[] nodeArr = new Node[this.f463b.length + 1];
                System.arraycopy(this.f463b, 0, nodeArr, 0, this.f463b.length);
                nodeArr[this.f463b.length] = node;
                this.f463b = nodeArr;
                return;
            }
        }
        if (this.f462a == null) {
            this.f462a = new Node[1];
            this.f462a[0] = node;
        } else {
            Node[] nodeArr2 = new Node[this.f462a.length + 1];
            System.arraycopy(this.f462a, 0, nodeArr2, 0, this.f462a.length);
            nodeArr2[this.f462a.length] = node;
            this.f462a = nodeArr2;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m218a(Node node, Texture2D[] texture2DArr, boolean z) {
        if (!(node instanceof Mesh)) {
            if (node instanceof Group) {
                for (int i = 0; i < ((Group) node).getChildCount(); i++) {
                    m218a(((Group) node).getChild(i), texture2DArr, z);
                }
                return;
            }
            return;
        }
        int userID = ((Mesh) node).getUserID();
        for (int i2 = 0; i2 < ((Mesh) node).getSubmeshCount(); i2++) {
            Appearance appearance = ((Mesh) node).getAppearance(i2);
            if (z) {
                appearance.setCompositingMode(f455a);
                appearance.setPolygonMode(f459b);
            } else {
                appearance.setCompositingMode((CompositingMode) null);
                appearance.setPolygonMode(f456a);
            }
            appearance.setMaterial((Material) null);
            if (appearance.getTexture(0) != null && texture2DArr != null) {
                if (userID < texture2DArr.length) {
                    appearance.setTexture(0, texture2DArr[userID]);
                } else {
                    appearance.setTexture(0, texture2DArr[0]);
                }
            }
            ((Mesh) node).setAppearance(i2, appearance);
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m219a(Node node) {
        if (!(node instanceof Group)) {
            if (!(node instanceof Mesh)) {
                return false;
            }
            for (int i = 0; i < ((Mesh) node).getSubmeshCount(); i++) {
                Material material = ((Mesh) node).getAppearance(i).getMaterial();
                if (material != null && material.getColor(8192) == 65280) {
                    return true;
                }
            }
            return false;
        }
        for (int i2 = 0; i2 < ((Group) node).getChildCount(); i2++) {
            Mesh child = ((Group) node).getChild(i2);
            if (child instanceof Mesh) {
                for (int i3 = 0; i3 < child.getSubmeshCount(); i3++) {
                    Material material2 = child.getAppearance(i3).getMaterial();
                    if (material2 != null && material2.getColor(8192) == 65280) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: d */
    private static void m220d() {
        if (f456a == null) {
            f456a = new PolygonMode();
            f456a.setCulling(160);
            f456a.setShading(164);
        }
        if (f459b == null) {
            f459b = new PolygonMode();
            f459b.setCulling(162);
            f459b.setShading(164);
        }
        if (f455a == null) {
            f455a = new CompositingMode();
            f455a.setBlending(64);
            f455a.setDepthTestEnable(true);
            f455a.setDepthWriteEnable(false);
        }
    }

    @Override // p000.AbstractC0048bu
    /* JADX INFO: renamed from: a */
    public final AbstractC0023aw mo117a() {
        return new C0067d(this);
    }

    @Override // p000.AbstractC0048bu
    /* JADX INFO: renamed from: a */
    public final void mo118a(AbstractC0085v abstractC0085v) {
        if (this.f462a != null) {
            for (int i = 0; i < this.f462a.length; i++) {
                m218a(this.f462a[i], ((C0082s) abstractC0085v).f526a, false);
            }
        }
        if (this.f463b != null) {
            for (int i2 = 0; i2 < this.f463b.length; i2++) {
                m218a(this.f463b[i2], ((C0082s) abstractC0085v).f526a, true);
            }
        }
    }

    @Override // p000.AbstractC0048bu
    /* JADX INFO: renamed from: b */
    public final void mo119b() {
        int i = 0;
        if (this.f462a != null) {
            ((AbstractC0048bu) this).f389c.m236a(f458a);
            f457a.set(f458a);
            if (this.f464c <= 0) {
                while (i < this.f462a.length) {
                    C0004ad.f29a.render(this.f462a[i], f457a);
                    i++;
                }
            } else {
                while (i < this.f462a.length) {
                    this.f462a[i].animate(this.f468f);
                    C0004ad.f29a.render(this.f462a[i], f457a);
                    i++;
                }
            }
        }
    }

    @Override // p000.AbstractC0048bu
    /* JADX INFO: renamed from: c */
    public final void mo168c() {
        int i = 0;
        if (this.f463b != null) {
            ((AbstractC0048bu) this).f389c.m236a(f458a);
            f457a.set(f458a);
            if (this.f464c <= 0) {
                while (i < this.f463b.length) {
                    C0004ad.f29a.render(this.f463b[i], f457a);
                    i++;
                }
            } else {
                while (i < this.f463b.length) {
                    this.f463b[i].animate(this.f468f);
                    C0004ad.f29a.render(this.f463b[i], f457a);
                    i++;
                }
            }
        }
    }
}
