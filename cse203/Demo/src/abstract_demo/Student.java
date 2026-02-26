package abstract_demo;
public abstract class Student {// lớp abstract
    private String name;
    private double score;
    private String id;
    public abstract void diHoc(); // Phương thức abstract

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    public Student(String name, double score) {
        this.name = name;
        this.score = score;
        
    }
    


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public double getScore() {
        return score;
    }


    public void setScore(double score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return "Student [name=" + name + ", score=" + score + "]";
    }

    
    


}
