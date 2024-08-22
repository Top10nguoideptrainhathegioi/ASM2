public class Student {
    private String name;
    private int age;
    private int gender;
    private String address;
    private Double grade;
    private String code;
    static int count =0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Student (String code, String name, int age, int gender, String address, Double grade){
        this.code = code;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.grade = grade;
        count += 1;
    }

    public String StudentToString(){
        String genderStr = Integer.toString(getGender());
        if(genderStr.equals("1")){
            genderStr = "Nam";
        } else if (genderStr.equals("2")) {
            genderStr = "Nu";
        }
        else {
            genderStr ="Khong co";
        }
        return  "\n"
                +"Student code: " +code+"\n" +"Student name: "+name+"\n" +"Student age: "+age+"\n"
                +"Student gender: " +genderStr+"\n" +"Student Address: "+address+"\n"
                +"Student grade: "+grade+"\n";
    }
}
