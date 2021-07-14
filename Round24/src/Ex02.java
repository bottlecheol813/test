import java.util.List;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		DbManager db= new DbManager();
		List<Person> list = null;
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("1.��� 2.��ü��ȸ 3.��ȸ 4.���� 0.����");
			int x = Integer.parseInt(scan.nextLine());
			if(x ==1) {
				System.out.print("�̸�: ");
				String name = scan.nextLine();
				
				System.out.println("����: ");
				int age = Integer.parseInt(scan.nextLine());
				
				Person p1 = new Person(name, age);
				db.insert(p1);
			} else if (x == 2) {
				list=db.selectAll();
				for(Person p:list) {
					System.out.println(p.getName()+" : "+p.getAge());
				}
			} else if (x == 3) {
				System.out.print("�̸�: ");
				String name = scan.nextLine();
				System.out.println(db.select(name));
			} else if (x == 4) {
				System.out.println("�̸�: ");
				String name = scan.nextLine();
				int r = db.delete(name);
				if (r == 1) {
					System.out.println("���� �Ϸ�");
				} else {
					System.out.println("���� ����");
				}
			} else if (x == 5) {
				System.out.print("���̸� ���� �� �̸�:");
				String name=scan.nextLine();
				System.out.print("���� �� ����:");
				int age=Integer.parseInt(scan.nextLine());
				int r=db.update(name,age);
				if(r==1)System.out.println("���� �Ǿ����ϴ�.");
				else System.out.println("���� �� �� �����ϴ�.");

			} else if ( x == 0) {
			
				break;
			}
			
			
			
		}

	}

}
