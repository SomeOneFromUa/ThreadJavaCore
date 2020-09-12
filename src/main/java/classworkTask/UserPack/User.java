package classworkTask.UserPack;

import classworkTask.postsPack.Post;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    Address AddressObject;
    private String phone;
    private String website;
    Company CompanyObject;
    private ArrayList<Post> posts;


    public void getPostsOfUser(ArrayList<Post> allPosts){
        for (Post post : allPosts) {
            if (post.getUserId() == this.id){
                this.posts.add(post);
            }
        }
    }

    public User() {
    }

    public User(int id, String name, String username, String email, Address addressObject, String phone, String website, Company companyObject) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        AddressObject = addressObject;
        this.phone = phone;
        this.website = website;
        CompanyObject = companyObject;
        this.posts = new ArrayList<>();

    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddressObject() {
        return AddressObject;
    }

    public void setAddressObject(Address addressObject) {
        AddressObject = addressObject;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompanyObject() {
        return CompanyObject;
    }

    public void setCompanyObject(Company companyObject) {
        CompanyObject = companyObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Float.compare(user.id, id) == 0 &&
                name.equals(user.name) &&
                username.equals(user.username) &&
                email.equals(user.email) &&
                AddressObject.equals(user.AddressObject) &&
                phone.equals(user.phone) &&
                website.equals(user.website) &&
                CompanyObject.equals(user.CompanyObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, email, AddressObject, phone, website, CompanyObject);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", AddressObject=" + AddressObject +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", CompanyObject=" + CompanyObject +
                '}';
    }
}
