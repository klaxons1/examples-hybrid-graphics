package javax.microedition.m3g;

import com.nokia.phone.p000ri.m3g.C0000GL;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class Appearance extends Object3D {
    private CompositingMode compositingMode;
    private Fog fog;
    private int layer;
    private Material material;
    private PolygonMode polygonMode;
    private Texture2D[] textures = new Texture2D[Graphics3D.getNumTextureUnits()];

    void apply(float f) {
        if (this.compositingMode == null) {
            CompositingMode.applyDefaults();
        } else {
            this.compositingMode.apply();
        }
        if (this.fog == null) {
            Fog.applyDefaults();
        } else {
            this.fog.apply();
        }
        if (this.polygonMode == null) {
            PolygonMode.applyDefaults();
        } else {
            this.polygonMode.apply();
        }
        if (this.material == null) {
            Material.applyDefaults();
        } else {
            this.material.apply(f);
        }
        for (int i = 0; i < this.textures.length; i++) {
            C0000GL.ActiveTexture(C0000GL.TEXTURE0 + i);
            if (this.textures[i] == null) {
                Texture2D.applyDefaults();
            } else {
                this.textures[i].apply();
            }
        }
    }

    @Override // javax.microedition.m3g.Object3D
    int applyAnimation(int i) {
        int iMin = Integer.MAX_VALUE;
        if (this.compositingMode != null) {
            iMin = Math.min(Integer.MAX_VALUE, this.compositingMode.animate(i));
        }
        if (this.fog != null) {
            iMin = Math.min(iMin, this.fog.animate(i));
        }
        if (this.material != null) {
            iMin = Math.min(iMin, this.material.animate(i));
        }
        int iMin2 = iMin;
        for (int i2 = 0; i2 < this.textures.length; i2++) {
            if (this.textures[i2] != null) {
                iMin2 = Math.min(iMin2, this.textures[i2].animate(i));
            }
        }
        return iMin2;
    }

    void applySprite() {
        if (this.compositingMode == null) {
            CompositingMode.applyDefaults();
        } else {
            this.compositingMode.apply();
        }
        if (this.fog == null) {
            Fog.applyDefaults();
        } else {
            this.fog.apply();
        }
        for (int i = 0; i < this.textures.length; i++) {
            C0000GL.ActiveTexture(C0000GL.TEXTURE0 + i);
            Texture2D.applyDefaults();
        }
    }

    @Override // javax.microedition.m3g.Object3D
    Object3D createDuplicate() {
        Appearance appearance = new Appearance();
        appearance.copy(this);
        appearance.compositingMode = this.compositingMode;
        appearance.fog = this.fog;
        appearance.layer = this.layer;
        appearance.polygonMode = this.polygonMode;
        appearance.material = this.material;
        for (int i = 0; i < this.textures.length; i++) {
            appearance.textures[i] = this.textures[i];
        }
        return appearance;
    }

    @Override // javax.microedition.m3g.Object3D
    int doGetReferences(Object3D[] object3DArr) {
        int iDoGetReferences = super.doGetReferences(object3DArr);
        if (this.compositingMode != null) {
            if (object3DArr != null) {
                object3DArr[iDoGetReferences] = this.compositingMode;
            }
            iDoGetReferences++;
        }
        if (this.polygonMode != null) {
            if (object3DArr != null) {
                object3DArr[iDoGetReferences] = this.polygonMode;
            }
            iDoGetReferences++;
        }
        if (this.fog != null) {
            if (object3DArr != null) {
                object3DArr[iDoGetReferences] = this.fog;
            }
            iDoGetReferences++;
        }
        if (this.material != null) {
            if (object3DArr != null) {
                object3DArr[iDoGetReferences] = this.material;
            }
            iDoGetReferences++;
        }
        int i = iDoGetReferences;
        for (int i2 = 0; i2 < this.textures.length; i2++) {
            if (this.textures[i2] != null) {
                if (object3DArr != null) {
                    object3DArr[i] = this.textures[i2];
                }
                i++;
            }
        }
        return i;
    }

    public CompositingMode getCompositingMode() {
        return this.compositingMode;
    }

    public Fog getFog() {
        return this.fog;
    }

    public int getLayer() {
        return this.layer;
    }

    public Material getMaterial() {
        return this.material;
    }

    public PolygonMode getPolygonMode() {
        return this.polygonMode;
    }

    int getSortKey() {
        int i = this.layer << 25;
        return (this.compositingMode == null || this.compositingMode.getBlending() == 68) ? i : i + 16777216;
    }

    public Texture2D getTexture(int i) {
        return this.textures[i];
    }

    int getVertexMask() {
        int i = this.material != null ? 3 : 1;
        for (int i2 = 0; i2 < this.textures.length; i2++) {
            if (this.textures[i2] != null) {
                i |= 8 << i2;
            }
        }
        return i;
    }

    public void setCompositingMode(CompositingMode compositingMode) {
        this.compositingMode = compositingMode;
    }

    public void setFog(Fog fog) {
        this.fog = fog;
    }

    public void setLayer(int i) {
        if (i < -63 || i > 63) {
            throw new IndexOutOfBoundsException();
        }
        this.layer = i;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setPolygonMode(PolygonMode polygonMode) {
        this.polygonMode = polygonMode;
    }

    public void setTexture(int i, Texture2D texture2D) {
        this.textures[i] = texture2D;
    }
}
