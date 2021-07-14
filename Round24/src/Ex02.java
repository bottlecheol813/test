import java.util.List;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		DbManager db= new DbManager();
		List<Person> list = null;
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("1.등록 2.전체조회 3.조회 4.삭제 0.종료");
			int x = Integer.parseInt(scan.nextLine());
			if(x ==1) {
				System.out.print("이름: ");
				String name = scan.nextLine();
				
				System.out.println("나이: ");
				int age = Integer.parseInt(scan.nextLine());
				
				Person p1 = new Person(name, age);
				db.insert(p1);
			} else if (x == 2) {
				list=db.selectAll();
				for(Person p:list) {
					System.out.println(p.getName()+" : "+p.getAge());
				}
			} else if (x == 3) {
				System.out.print("이름: ");
				String name = scan.nextLine();
				System.out.println(db.select(name));
			} else if (x == 4) {
				System.out.println("이름: ");
				String name = scan.nextLine();
				int r = db.delete(name);
				if (r == 1) {
					System.out.println("삭제 완료");
				} else {
					System.out.println("삭제 실패");
				}
			} else if (x == 5) {
				System.out.print("나이를 수정 할 이름:");
				String name=scan.nextLine();
				System.out.print("수정 할 나이:");
				int age=Integer.parseInt(scan.nextLine());
				int r=db.update(name,age);
				if(r==1)System.out.println("수정 되었습니다.");
				else System.out.println("수정 할 수 없습니다.");

			} else if ( x == 0) {
			
				break;
			}
			
			
			
		}

	}

}
