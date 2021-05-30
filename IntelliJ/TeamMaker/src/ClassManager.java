import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ClassManager {

    private MemoryDB db;
    private Scanner sc;

    private final int MAX_TEAM_COUNT = 10;

    public ClassManager() {
        db = new MemoryDB();
        sc = new Scanner(System.in);
    }

    public void setData() {
        db.insert("우종성", GENDER.MALE, REGION.GYEONGGI, 33, 0);
        db.insert("권오선", GENDER.MALE, REGION.SEOUL, 33, 0);
        db.insert("윤상지", GENDER.MALE, REGION.GYEONGGI, 28, 0);
        db.insert("이강민", GENDER.MALE, REGION.SEOUL, 34, 0);
        db.insert("이윤지", GENDER.FEMALE, REGION.GYEONGGI, 28, 0);
        db.insert("이해성", GENDER.FEMALE, REGION.GYEONGGI, 25, 0);
        db.insert("이현아", GENDER.FEMALE, REGION.GYEONGGI, 26, 0);
        db.insert("이희수", GENDER.FEMALE, REGION.GYEONGGI, 26, 0);
        db.insert("정원우", GENDER.MALE, REGION.GYEONGGI, 26, 0);
        db.insert("조병철", GENDER.MALE, REGION.GYEONGGI, 24, 0);
        db.insert("조정희", GENDER.MALE, REGION.GYEONGGI, 29, 0);
        db.insert("최호열", GENDER.MALE, REGION.GYEONGGI, 31, 0);
    }

    public void start() {
        boolean play = true;
        while (play) {
            System.out.println("============================================================");
            System.out.println("작업을 선택해주세요.");
            System.out.printf("1. 뽑기\t2. 학생 추가\t3. 학생 삭제\t4. 학생 정보 열람\t5. 종료\n");
            System.out.println("============================================================");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    makeTeamAge();
                    break;
                case 2:
                    insert();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    showAll();
                    break;
                case 5:
                    play = false;
                    break;
            }
        }

        sc.close();
    }

    private int inputTeamCount() {
        System.out.printf("[입력 모드] 팀 개수 (최대 %d개) : ", MAX_TEAM_COUNT);
        int teamCount = sc.nextInt();

        if (teamCount > MAX_TEAM_COUNT) {
            System.out.printf("[ERROR] 생성 가능한 팀 개수는 최대 %d개 입니다.\n", MAX_TEAM_COUNT);
            return -1;
        }
        return teamCount;
    }

    private void makeTeamRandom() {
        int teamCount = inputTeamCount();
        if (teamCount <= -1)
            return;

        ArrayList<Student> studentList = db.selectAll();

        int[] teamNumberArr = new int[studentList.size()];
        for (int i = 0; i < teamNumberArr.length; i++) {
            teamNumberArr[i] = i % teamCount;
        }

        for (int i = 0; i < teamNumberArr.length; i++) {
            int random01 = (int)(Math.random() * teamNumberArr.length);
            int random02 = (int)(Math.random() * teamNumberArr.length);
            int temp = teamNumberArr[random01];
            teamNumberArr[random01] = teamNumberArr[random02];
            teamNumberArr[random02] = temp;
        }

        for (int i = 0; i < studentList.size(); i++) {
            studentList.get(i).team = teamNumberArr[i];
        }

        showTeam();
    }

    private void makeTeamAge() {
        int teamCount = inputTeamCount();
        if (teamCount <= -1)
            return;

        ArrayList<Student> studentList = db.selectAll();
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student left, Student right) {
                if (left.age == right.age)
                    return 0;
                else if (left.age < right.age)
                    return 1;
                else
                    return -1;
            }
        });

        for (int i = 0; i < studentList.size(); i++) {
            studentList.get(i).team = i % 2;
        }

        showTeam();
    }

    private void insert() {
        System.out.print("[입력 모드] 이름 : ");
        String name = sc.next();
        System.out.print("[입력 모드] 성별 (남자 0, 여자 1) : ");
        int gender = sc.nextInt();
        System.out.print("[입력 모드] 지역 (서울 0, 경기 1) : ");
        int region = sc.nextInt();
        System.out.print("[입력 모드] 나이 : ");
        int age = sc.nextInt();
        System.out.print("[입력 모드] POINT (0 ~ 100) : ");
        int point = sc.nextInt();

        db.insert(name, GENDER.values()[gender], REGION.values()[region], age, point);
    }

    private void delete() {
        System.out.print("[입력 모드] 삭제할 학생 이름 : ");
        String name = sc.next();

        db.delete(name);
    }

    private void showTeam() {
        for (int i = 0; i < MAX_TEAM_COUNT; i++ ) {
            ArrayList<Student> list = db.findByTeam(i);
            if (list.size() <= 0) {
                break;
            }

            list.sort(new Comparator<Student>() {
                @Override
                public int compare(Student left, Student right) {
                    if (left.age == right.age)
                        return 0;
                    else if (left.age < right.age)
                        return 1;
                    else
                        return -1;
                }
            });

            System.out.printf("Team %d (%d명)\n", i, list.size());
            for (Student student : list) {
                System.out.println(student);
            }
        }
    }

    private void showAll() {
        ArrayList<Student> list = db.selectAll();

        for (Student student : list) {
            System.out.println(student);
        }
    }
}
