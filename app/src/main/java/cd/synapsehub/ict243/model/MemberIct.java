package cd.synapsehub.ict243.model;

public class MemberIct {

    public MemberIct() {

    }

    public MemberIct(String mbfullname, String mbtitle, String mbdescr, String mblocation, String mbcompetences, String mbphoto) {
        this.mbfullname = mbfullname;
        this.mbtitle = mbtitle;
        this.mbdescr = mbdescr;
        this.mblocation = mblocation;
        this.mbcompetences = mbcompetences;
        this.mbphoto = mbphoto;
    }

    private String mbfullname;
    private String mbtitle;
    private String mbdescr;
    private String mblocation;
    private String mbcompetences;
    private String mbphoto;

    public String getMbfullname() {
        return mbfullname;
    }

    public void setMbfullname(String mbfullname) {
        this.mbfullname = mbfullname;
    }

    public String getMbtitle() {
        return mbtitle;
    }

    public void setMbtitle(String mbtitle) {
        this.mbtitle = mbtitle;
    }

    public String getMbdescr() {
        return mbdescr;
    }

    public void setMbdescr(String mbdescr) {
        this.mbdescr = mbdescr;
    }

    public String getMblocation() {
        return mblocation;
    }

    public void setMblocation(String mblocation) {
        this.mblocation = mblocation;
    }

    public String getMbcompetences() {
        return mbcompetences;
    }

    public void setMbcompetences(String mbcompetences) {
        this.mbcompetences = mbcompetences;
    }

    public String getMbphoto() {
        return mbphoto;
    }

    public void setMbphoto(String mbphoto) {
        this.mbphoto = mbphoto;
    }
}
