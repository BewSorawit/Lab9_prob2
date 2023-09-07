
public class Student {
    private String name;
    private String gpa;
    private double total = 0;

    public Student(String name, String gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public void show() {

        try {
            if (isDigit()) {
                throw new DigitException("DigitException :(digit is not allowed in name) can not display.");
            } else if (isSpace()) {
                throw new SpaceException("SpaceException :(space is not allowed in name) can not display.");
            } else if (checkGpa() && isI()) {
                throw new IncompleteException("IncompleteException :(grade I is incomplete) can not display.");
            } else if (checkGpa() == false) {
                throw new GradeException("GradeException :(grade must be A B C D E F) can not display.");
            } else {
                System.out.println(name + " registered " + gpa.length() + " subjects and got GPA " + total);
            }
        } catch (DigitException e) {
            System.out.println(e.getMessage());
        } catch (SpaceException e) {
            System.out.println(e.getMessage());
        } catch (IncompleteException e) {
            System.out.println(e.getMessage());
        } catch (GradeException e) {
            System.out.println(e.getMessage());
        }

    }

    public boolean isDigit() {
        for (char i : name.toCharArray()) {
            if (Character.isDigit(i)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpace() {
        for (char i : name.toCharArray()) {
            if (i == ' ') {
                return true;
            }
        }
        return false;
    }

    public boolean checkGpa() {
        for (char i : gpa.toCharArray()) {
            if (i == 'A') {
                total += 4;
            } else if (i == 'B') {
                total += 3;
            } else if (i == 'C') {
                total += 2;
            } else if (i == 'D') {
                total += 1;
            } else if (i == 'E' || i == 'F') {
                total += 0;
            } else {
                if (i == 'I') {
                    return true;
                }
                return false;
            }
        }
        total /= gpa.length();
        return true;
    }

    public boolean isI() {
        for (char i : gpa.toCharArray()) {
            if (i == 'I') {
                return true;
            }
        }
        return false;
    }

}
