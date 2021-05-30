enum GENDER {
    MALE,
    FEMALE,
}

enum REGION {
    SEOUL,
    GYEONGGI,
}

public class Student {

    public String name;
    public GENDER gender;
    public REGION region;
    public int age;
    public int point;
    public int team;

    public Student(String name, GENDER gender, REGION region, int age, int point) {
        this.name = name;
        this.gender = gender;
        this.region = region;
        this.age = age;
        this.point = point;
        this.team = 0;
    }

    public int getPoint() {

        return 0;
    }

    @Override
    public String toString() {
        return String.format("이름 : %s, 성별 : %s, 지역 : %s, 나이 : %d, point : %d", name, gender.toString(), region.toString(), age, point);
    }
}
