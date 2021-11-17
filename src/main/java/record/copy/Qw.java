package record.copy;

public class Qw extends Qp implements Cloneable{
    Long id;
    String w1;
    Integer w2;
    int w3;
    QQ w4;

    public String getW1() {
        return w1;
    }

    public void setW1(String w1) {
        this.w1 = w1;
    }

    public Integer getW2() {
        return w2;
    }

    public void setW2(Integer w2) {
        this.w2 = w2;
    }

    public int getW3() {
        return w3;
    }

    public void setW3(int w3) {
        this.w3 = w3;
    }

    public QQ getW4() {
        return w4;
    }

    public void setW4(QQ w4) {
        this.w4 = w4;
    }

    public Qw clone() {
        Qw o = null;
        try {
            o = (Qw) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        return o;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
