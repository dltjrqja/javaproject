import java.util.Scanner;

class BasicInformation {
 public String getAddress() {
 return address;
 }

 public void setAddress(String address) {
  this.address = address;
 }

 public String getLocation() {
  return location;
 }

 public void setLocation(String location) {
  this.location = location;
 }

 String address;
 String location;
}

class Punishmentpoint {
 public String getDemerit() {
  return demerit;
 }
 public void setDemerit(String demerit) {
  this.demerit = demerit;
 }
 public String getMerit() {
  return merit;
 }
 public void setMerit(String merit) {
  this.merit = merit;
 }
 String demerit;
 String merit;
}

class task {
 String administration;
 String Administrativeaffairs;
}

public class SchoolTest {

 public static void main(String[] args) {
  // TODO Auto-generated method stub
  Scanner s = new Scanner(System.in);
  String address;
  String location;
  BasicInformation bf = new BasicInformation();
  System.out.println("�ּҸ��Է��ϼ���.");
  bf.setAddress(s.next());
  System.out.println("�ּҴ�\t" + bf.getAddress());
  System.out.println("��ġ���Է��ϼ���");
  bf.setLocation(s.next());
  System.out.println("��ġ��\t" + bf.getLocation());
 }
}

