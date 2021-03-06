import exception.OldException;
import exception.YoungException;

public class Teacher extends People implements Comparable<Teacher> {

    private int basePay;
    private int workDays;

    public Teacher(String name, String surname, int age, Address address, String gender) {
        super(name, surname, age, address, gender);
        this.basePay = 50;
        this.workDays = 5;
    }

    @Override
    public String getGender() {
        return super.getGender();
    }

    @Override
    public void setGender(String gender) {
        super.setGender(gender);
    }



    //private String teacherPayment;

    /*public void TeacherPayment () {
        System.out.println(basePay*workDays);
        }*/
    public void setWorkDays(int workDays) {
        if (workDays < 31 && workDays > 1)
            this.workDays = workDays;
    }

    int getWorkdays() {
        return workDays;
    }

    public void setBasePay(int basePay) {
        if (basePay < 100 && basePay > 45)
            this.basePay = basePay;
    }

    int getBasePay() {
        return basePay;
    }

    public int TeacherPayment() {
        int teacherPayment = basePay * workDays;
        return teacherPayment;
    }


//    public void setBasePay(int basePay) {
//        this.basePay = basePay;
//    }

//    public void setWorkDays(int workDays) {
//        this.workDays = workDays;
//    }

    @Override
    String getName() {
        return super.getName();
    }

    @Override
    public void setAge(int age) {
        try {
            CheckYoungAge(age);
            CheckOldAge(age);
            super.setAge(age);
        } catch (YoungException | OldException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private void CheckYoungAge(int age) throws YoungException {

        if (age < 22) {
            throw new YoungException("слишком молод");
        }
    }

    public static void CheckOldAge(int age) throws OldException {

        if (age > 100) {
            throw new OldException("старик");
        }
    }

    @Override
    public String toString() {
        return "teacher: " + super.getName() + " " + getSurname() + " age: " + super.getAge() + " gender: " + super.getGender() + " address: " + super.getAddress() + " payment: " + this.TeacherPayment();
    }

    @Override
    public int compareTo(Teacher o) {
        return this.getSurname().compareTo(o.getSurname());
    }
}



