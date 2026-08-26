package p000;

import javax.microedition.m3g.Appearance;
import javax.microedition.m3g.CompositingMode;
import javax.microedition.m3g.Group;
import javax.microedition.m3g.Loader;
import javax.microedition.m3g.Material;
import javax.microedition.m3g.Mesh;
import javax.microedition.m3g.Node;
import javax.microedition.m3g.Texture2D;
import javax.microedition.m3g.Transform;

/* JADX INFO: renamed from: ay */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0025ay extends AbstractC0048bu {

    /* JADX INFO: renamed from: a */
    private static CompositingMode f273a;

    /* JADX INFO: renamed from: a */
    private static Transform f274a = new Transform();

    /* JADX INFO: renamed from: a */
    private static float[] f275a = new float[16];

    /* JADX INFO: renamed from: a */
    private Node f276a;

    private C0025ay(C0025ay c0025ay) {
        super(new StringBuffer().append(((AbstractC0023aw) c0025ay).f258a).append("Copy").toString());
        ((AbstractC0043bp) this).f374b = 0;
        this.f276a = c0025ay.f276a;
        ((AbstractC0048bu) this).f388a = ((AbstractC0048bu) c0025ay).f388a;
        ((AbstractC0023aw) this).f259a = ((AbstractC0023aw) c0025ay).f259a;
    }

    public C0025ay(String str, String str2) {
        super(str);
        m115a(str2);
        ((AbstractC0043bp) this).f374b = 0;
        if (f273a == null) {
            f273a = new CompositingMode();
            f273a.setDepthTestEnable(false);
            f273a.setDepthWriteEnable(false);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m115a(String str) {
        try {
            Node[] nodeArrLoad = Loader.load(new StringBuffer().append(str).append(".m3g").toString());
            for (int i = 0; i < nodeArrLoad.length; i++) {
                if (nodeArrLoad[i] instanceof Group) {
                    this.f276a = nodeArrLoad[i];
                    return;
                }
            }
        } catch (Exception e) {
            this.f276a = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m116a(Group group, Texture2D[] texture2DArr) {
        for (int i = 0; i < group.getChildCount(); i++) {
            Mesh child = group.getChild(i);
            if (child instanceof Mesh) {
                int userID = child.getUserID();
                for (int i2 = 0; i2 < child.getSubmeshCount(); i2++) {
                    Appearance appearance = child.getAppearance(i2);
                    appearance.setMaterial((Material) null);
                    appearance.setCompositingMode(f273a);
                    if (appearance.getTexture(0) != null) {
                        if (texture2DArr == null) {
                            appearance.setTexture(0, (Texture2D) null);
                        } else if (userID < texture2DArr.length) {
                            appearance.setTexture(0, texture2DArr[userID]);
                        } else {
                            appearance.setTexture(0, texture2DArr[0]);
                        }
                    }
                }
            } else if (child instanceof Group) {
                m116a((Group) child, texture2DArr);
            }
        }
    }

    @Override // p000.AbstractC0048bu
    /* JADX INFO: renamed from: a */
    public final AbstractC0023aw mo117a() {
        return new C0025ay(this);
    }

    @Override // p000.AbstractC0048bu, p000.AbstractC0023aw
    /* JADX INFO: renamed from: a */
    public final void mo20a(AbstractC0038bk abstractC0038bk, C0086w c0086w) {
        if (((AbstractC0023aw) this).f259a) {
            ((AbstractC0048bu) this).f389c = ((AbstractC0023aw) abstractC0038bk).f261b.m229a(((AbstractC0048bu) this).f389c);
            c0086w.m272a(((AbstractC0048bu) this).f388a, this);
        }
    }

    @Override // p000.AbstractC0048bu
    /* JADX INFO: renamed from: a */
    public final void mo118a(AbstractC0085v abstractC0085v) {
        m116a((Group) this.f276a, ((C0082s) abstractC0085v).f526a);
    }

    @Override // p000.AbstractC0048bu
    /* JADX INFO: renamed from: b */
    public final void mo119b() {
        ((AbstractC0048bu) this).f389c.m236a(f275a);
        float[] fArr = f275a;
        float[] fArr2 = f275a;
        f275a[11] = 0.0f;
        fArr2[7] = 0.0f;
        fArr[3] = 0.0f;
        f274a.set(f275a);
        C0004ad.f29a.render(this.f276a, f274a);
    }
}
