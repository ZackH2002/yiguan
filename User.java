public class User {
    private int id;
    private String umane;
    private String authority;
    private String pwd;
    private Date entry_date;

    public User() {
    }

    public User(int id, String umane, String authority, String pwd, Date entry_date) {
        this.id = id;
        this.umane = umane;
        this.authority = authority;
        this.pwd = pwd;
        this.entry_date = entry_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUmane() {
        return umane;
    }

    public void setUmane(String umane) {
        this.umane = umane;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }
}
