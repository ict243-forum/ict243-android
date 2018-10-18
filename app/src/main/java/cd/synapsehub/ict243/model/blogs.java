package cd.synapsehub.ict243.model;

/**
 * Created by EKENE on 11/4/2017.
 */

public class blogs {

    private String posttitle, postdesc, photo, postauthor;

    public blogs(String title, String desc, String imageUrl, String username) {
        this.posttitle = title;
        this.postdesc = desc;
        this.photo=imageUrl;
        this.postauthor = username;
    }

    public blogs() {
    }

    public String getPosttitle() {
        return posttitle;
    }

    public void setPosttitle(String posttitle) {
        this.posttitle = posttitle;
    }

    public String getPostdesc() {
        return postdesc;
    }

    public void setPostdesc(String postdesc) {
        this.postdesc = postdesc;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPostauthor() {
        return postauthor;
    }

    public void setPostauthor(String postauthor) {
        this.postauthor = postauthor;
    }
}
