package fit.arseny.ta.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LabSecond {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Float a;
    private Float b;
    private Float c;
    private Float d;
    private Float x1;
    private Float x2;

    public LabSecond(){}

    public LabSecond(Float a, Float b, Float c, Float d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;

        this.count();
    }

    public void count(){
        Float D = b*b - 4 * a * c;   // ax2+bx+c,  x1 = (- b + sqrt(D)) / 2a

        if(D < 0){
            return;
        }

        Float da = d/a;
        Float db = d/b;
        Float dc = d/c;

        double x1 = ((-1 * b) + Math.sqrt(D))/2*a;
        this.x1 = (float)x1;
        if(D == 0){
            return;
        }

        double x2 = ((-1 * b) + Math.sqrt(D))/2*a;
        this.x2 = (float)x2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getA() {
        return a;
    }

    public void setA(Float a) {
        this.a = a;
    }

    public Float getB() {
        return b;
    }

    public void setB(Float b) {
        this.b = b;
    }

    public Float getC() {
        return c;
    }

    public void setC(Float c) {
        this.c = c;
    }

    public Float getD() {
        return d;
    }

    public void setD(Float d) {
        this.d = d;
    }


    public Float getX1() {
        return x1;
    }

    public void setX1(Float x1) {
        this.x1 = x1;
    }

    public Float getX2() {
        return x2;
    }

    public void setX2(Float x2) {
        this.x2 = x2;
    }
}
