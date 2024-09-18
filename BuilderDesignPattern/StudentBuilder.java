package BuilderDesignPattern;

class Student {
    private String name;
    private int age;
    private float marks;
    private char gender;
    private double psp;

    private Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.marks = builder.marks;
        this.gender = builder.gender;
        this.psp = builder.psp;
    }

    public static class Builder {
        private String name;
        private int age;
        private float marks;
        private char gender;
        private double psp;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setMarks(float marks) {
            this.marks = marks;
            return this;
        }

        public Builder setGender(char gender) {
            this.gender = gender;
            return this;
        }

        public Builder setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getMarks() {
        return marks;
    }

    public char getGender() {
        return gender;
    }

    public double getPsp() {
        return psp;
    }

    public static Builder builder() {
        return new Builder();
    }
}

public class StudentBuilder {
    public static void main(String[] args) {
        Student student = Student.builder()
                .setName("Vitul")
                .setAge(26)
                .setMarks(78.89f)
                .setGender('M')
                .setPsp(9.4)
                .build();

        System.out.println("name: "+student.getName());
        System.out.println("age: "+student.getAge());
        System.out.println("marks: "+student.getMarks());
        System.out.println("gender: "+student.getGender());
        System.out.println("psp: "+student.getPsp());
    }
}
