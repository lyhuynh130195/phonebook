package model;

/**
 * Xây dựng ứng dụng quản lý danh bạ (sử dụng List, File, xử lý ngoại lệ,… để thực hiện các
 * yêu cầu). Ứng dụng cho phép người dùng quản lý thông tin danh bạ như họ tên, số điện thoại,
 * địa chỉ, email, facebook,... Yêu cầu của chức năng gồm
 */
public class PhoneBook {
    private String numberPhone;
    private String group;
    private String name;
    private String gender;
    private String address;
    private String birthday;
    private String email;

    public PhoneBook(String numberPhone, String group, String name, String gender, String address, String birthday,
                     String email) {
        this.numberPhone = numberPhone;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

    public PhoneBook() {
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return numberPhone +
                "," + group +
                "," + name +
                "," + gender +
                "," + address +
                "," + birthday +
                "," + email
                ;
    }
    public String showInfo(){
        return "DanhBa{" +
                "numberPhone='" + numberPhone + '\'' +
                ", group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
