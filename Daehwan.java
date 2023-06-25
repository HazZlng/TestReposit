//	유효성 검사 추가

package Test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Product {

	private int PK;
	private String name;
	private int price;
	private int stock;

	Product(int PK,String name,int price, int stock) {
		this.PK = PK;
		this.name = name;
		this.price = price;
		this.stock = stock;
		System.out.println(this.name + " 상품 생성 ! \n");
	}
	
	// 판매를 하는 함수
	int sell(int count) {					//	Update

		if(this.stock >= count) {			//	재고가 구매 개수 보다 많거나 같아 ?
			this.stock -= count;			//	그러면 재고에서 구매 개수 만큼 재고를 줄여.
			int total = count * this.price;	//	총 가격 = 개수 x 가격.
			return total;
		}
		else {
			return 0;						//	재고가 부족해 ? 그러면 구매 불가능.
			//	반환값으로 총 가격 = 0;
		}
	}

	void changeStock(int stock) {			//	U : 재고를 변경해줄 메서드.

		Scanner sc = new Scanner(System.in);				

		while(true) {	
			System.out.print("재고를 더하려면 1번, 빼려면 2번을 눌러주세요 >> (뒤로가기 : 3) ");
			int select = sc.nextInt();		//	재고를 더할지 뺄지 선택하기 위해서 입력을 받기 위한 변수.
			sc.nextLine();

			if(select == 1) {

				this.stock += stock;
				System.out.println("재고가 변경되었습니다. 현재 재고 : " + this.stock + "\n");
				break;
			}
			else if(select == 2) {

				this.stock -= stock;
				System.out.println("재고가 변경되었습니다. 현재 재고 : " + this.stock + "\n");
				break;
			}
			else if(select == 3) {
				System.out.println("재고 변경을 하지 않고, 관리자 모드로 돌아갑니다. \n");
				break;
			}
			else {							//	유효성 : 1, 2번이 아니면 입력을 다시 받기 위해.
				System.out.println("유효하지 않는 번호 입니다. 다시 입력해 주세요. \n");
				continue;
			}
		}
	}

	@Override
	public String toString() {				//	Read

		return "[" + this.PK + "]번 상품 " + this.name + "은 " + this.price + "원 이고 재고는 " + this.stock + "개 입니다. \n";
	}

	public int getPK() {					//	외부에서 값을 받아온 PK 변수의 값을 결과값으로 토해내기 위한 게터.
		return PK;							
	}

	public void setPK(int pK) {				//	외부에서 값을 받아오는 세터.	
		PK = pK;							
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
}	//	class Product

public class Daehwan {
	static ArrayList<Product> data = new ArrayList<Product>();	
	static Scanner sc = new Scanner(System.in);
	static int numPK = 1001;
	
	static void mainMenu()
	{		
		//	상품 객체를 저장할 배열리스트.
		//	해당 배열리스트에 Product 타입만 사용 가능하도록 제너릭 처리.

		
		int select;																						//	사용자로부터 입력을 받기 위한 변수를 선언.

		while(true) {

			try {	

				System.out.println("==========프로그램========== \n");
				System.out.println("1.상품목록출력");
				System.out.println("2.구매하기");
				System.out.println("3.프로그램종료");
				System.out.println("========================= \n");

				System.out.print("목록을 선택 하세요 >> ");
				select = sc.nextInt();
				sc.nextLine();

				if(select == 1) {
					printData();					
				}	
				if(select == 2) {
					sellStock();
				}																
				else if(select == 3) {
					System.out.println("프로그램을 종료 합니다.");
					break;																					//	프로그램 종료.
				}
				else if(select == 7777) {																	//	관리자 모드 진입.
					numPK = adminMenu();
				}	//	관리자 모드의 else if문
				else if(!(0 < select && select < 3 || select == 7777)) {
					System.out.println("유효하지 않는 번호 입니다. (1 ~ 3) \n");										// 유효성 : 1, 2, 3, 7777를 제외한 숫자를 입력했을 경우.
					continue;
				}

			}
			catch(InputMismatchException e) {

				sc.nextLine();	
				System.out.println("올바르게 입력해 주세요. \n");
				//	continue; 생략
			}

		}	//	프로그램을 돌리기위한 while 무한 반복문

		sc.close();
	}
	static void sellStock() {
		boolean flag = false;
		
		while(true) {	
			int input = 0;
			if(data.isEmpty()) {																//	유효성 : 출력하려는데 상품이 없음.
				System.out.println("출력할 상품이 없습니다. \n");
				break;																			//	상품이 없으면 while문 탈출.
			}
			
			for(Product v : data) {
				System.out.println(v);											
			}
			
			try {
				System.out.print("상품의 번호를 선택 하세요 >> ");
				input = sc.nextInt();															//	상품의 번호를 입력하기 위한 지역 변수.
				sc.nextLine();
			} 
			catch(InputMismatchException e) {
				System.out.println("올바른 상품 번호를 입력해주세요.");
				continue;
			}
			
			for(int i = 0;i < data.size();i++) {	
				if(input == data.get(i).getPK()) {												// if에 한번이라도 걸리면 있는 번호.
					flag = true;
					break;
				}
			}
			
			if(!flag) {																			// if에 한번도 걸린적 없으면 없는 번호.
				System.out.println("해당 번호의 상품은 없습니다. \n");
				continue;
			}
			
			flag = false;																		//	true된 flag를 false로 다시 초기화.

			for(int i = 0; i < data.size(); i++) {	
				//	배열안의 객체를 다 루프하기 위한 for문 (객체를 다 비교 해봐야 하는 상황이니까)
				
//				배열의 i번째 (배열의 타입 == Product의 PK)
				if(input == data.get(i).getPK()) {												
					sc.nextLine();
					System.out.print("구매할 개수를 선택 하세요 >> ");
					int cnt = 0;
					try {
						cnt = sc.nextInt();	//	구매할 개수를 입력하기 위한 지역 변수.
						
					} catch(InputMismatchException e) {
						System.out.println("올바른 상품 번호를 입력해주세요.");
						i--;
						continue;
					}							
					
					if(cnt <= 0) {
						System.out.println("0개 이상으로 구매해주세요. \n");
						i--;
						continue;
					} else if(data.get(i).getStock() < cnt) {											//	유효성 : 구매하려고 하는데 재고 없음.
						System.out.println("구매할 " + data.get(i).getName() + "의 재고가 부족합니다.");
						System.out.println("현재 재고 : " + data.get(i).getStock() + "\n");
						break;
					} else {
						data.get(i).sell(cnt);
						System.out.println("구매 완료 ! \n");
						break;
					}
				}
			}											
			break;																				//	구매가 끝나면 while문을 탈출.		
		}
	}
	static void printData() {
		while(true) {	

			if(data.size() == 0) {																//	유효성 : 출력하려는데 상품이 없음.
				System.out.println("출력할 상품이 없습니다. \n");
				break;
			}
			for(Product v : data) {																//	.toString() 메서드를 재정의.
				System.out.println(v);
			}
			break;																				//	상품 목록 출력 하고 while문 탈출.
		}
	}
	
	static int adminMenu() {
		int pwCnt = 0;																			//	비밀번호 입력 횟수를 인지 하기 위한 지역 변수.
		while(true) {	

			if(pwCnt == 3) {
				System.out.println("비밀번호를 3번 틀렸습니다. 처음으로 돌아갑니다. \n");
				pwCnt = 0;
				break;
			}
			System.out.print("접근 권한이 없습니다. 비밀번호 입력 >> ");
			int pw = sc.nextInt();																	//	사용자로부터 입력을 받기 위한 지역 변수.
			sc.nextLine();

			if(pw == 2023) {

				System.out.println("관리자 모드로 진입 합니다. \n");
				while(true) {	
					System.out.println("==========프로그램 관리자 모드========== \n");
					System.out.println("1.상품추가");
					System.out.println("2.상품목록출력");
					System.out.println("3.상품재고변경");
					System.out.println("4.상품삭제");
					System.out.println("5.관리자모드종료");
					System.out.println("================================= \n");

					System.out.print("목록을 선택 하세요 >> ");
					int input = sc.nextInt();														//	사용자로부터 입력을 받기 위한 지역 변수.
					sc.nextLine();

					if(input == 1) {
						numPK = adminAddData();
						
						//	Product 객체가 생성될때, numPk 가져가고, 입력받은 name, price, stock
						//	전부 다 가져가. 근데, numPk는 main()에서 1001로 초기화 해줬고,
						//	상품의 고유번호는 상품 객체가 하나 생성될때마다 ++ 이 되야해.
					}
					if(input == 2) {
						adminPrintData();									
					}	
					else if(input == 3) {
						adminChangeStock();
					}
					else if(input == 4) {
						adminDeleteData();
					}
					else if(input == 5) {

						System.out.println("관리자 모드를 종료 합니다. \n");
						break;																	//	관리자 모드 종료.
					}
					else if(!(1 <= input && input <= 5)) {
						System.out.println("유효하지 않은 번호 입니다. (1 ~ 5) \n");
						continue;
					}
				}	//	관리자 모드의 while 무한 반복문
				break;																			//	관리자 모드 종료하면 while문 탈출.
			}	//	패스워드 통과시 진입되는 if문
			else {
				System.out.println("비밀번호가 틀렸습니다. (3번 틀릴경우 처음으로 돌아갑니다) \n");
				pwCnt++;
				continue;
			}
		}	//	관리자 모드의 else if문 안의 pwCnt while문	
		return numPK;
	}
	static void adminDeleteData() {
		boolean flag = false;
		while(true) {		

			if(data.isEmpty()) {											//	유효성 : 출력하려는데 상품이 없음.
				System.out.println("출력할 상품이 없습니다. \n");
				break;														//	상품이 없으면 while문 탈출.
			}
			for(Product v : data) {
				System.out.println(v);											
			}

			System.out.print("상품의 번호를 선택 하세요 >> ");
			int num = sc.nextInt();											//	상품의 번호를 입력하기 위한 지역 변수
			sc.nextLine();

			for(int i = 0;i < data.size();i++) {
				if(num == data.get(i).getPK()) {							// if에 한번이라도 걸리면 있는 번호.
					flag = true;
					break;
				}
			}
			if(!flag) {														// if에 한번도 걸린적 없으면 없는 번호.
				System.out.println("해당 번호의 상품은 없습니다. \n");
				continue;
			}
			flag = false;													//	true된 flag를 false로 다시 초기화.

			System.out.println("정말로 삭제 하시겠습니까 ?");
			System.out.print("맞으면 1번, 아니면 2번 >> ");
			int check = sc.nextInt();
			sc.nextLine();

			if(check == 1) {	
				for(int i = 0; i < data.size(); i++) {
					if(num == data.get(i).getPK()) {
						data.remove(i);
						System.out.println("상품이 삭제 되었습니다. \n");
						break;													//	삭제가 끝나면 즉시 for문 탈출.
					}
				}
			}
			else if(check == 2) {
				System.out.println("번호를 다시 입력 해주세요. \n");
				continue;
			}
			else {
				System.out.println("유효하지 않는 번호 입니다. (1 ~ 2) \n");
				continue;
			}
			break;																//	while문 탈출.
		}	
	}
	static void adminChangeStock() {
		boolean flag = false;
		
		while(true) {	

			if(data.isEmpty()) {											//	유효성 : 출력하려는데 상품이 없음.
				System.out.println("출력할 상품이 없습니다. \n");
				break;														//	상품이 없으면 while문 탈출.
			}
			for(Product v : data) {
				System.out.println(v);											
			}
			System.out.print("상품의 번호를 선택 하세요 >> ");
			int num = sc.nextInt();											//	상품의 번호를 입력하기 위한 지역 변수
			sc.nextLine();
			for(int i = 0;i < data.size();i++) {
				if(num == data.get(i).getPK()) {							// if에 한번이라도 걸리면 있는 번호.
					flag = true;
					break;
				}
			}
			if(!flag) {														// if에 한번도 걸린적 없으면 없는 번호.
				System.out.println("해당 번호의 상품은 없습니다. \n");
				continue;
			}
			flag = false;													//	true된 flag를 false로 다시 초기화.

			for(int i = 0; i < data.size(); i++) {							//	배열안의 객체를 다 루프하기 위한 for문 (객체를 다 비교 해봐야 하는 상황이니까)
				if(num == data.get(i).getPK()) {							//	num은 내가 입력한 상품의 고유번호 값
					System.out.print("재고를 몇개 더하실건가요? (빼실건가요?) >> ");
					int stock = sc.nextInt();								//	상품의 변경할 재고를 입력하기 위한 지역 변수				
					sc.nextLine();
					data.get(i).changeStock(stock);		
					break;													//	변경이 끝나면 즉시 for문 탈출.	
				}
			}
			break;															//	while문 탈출.
		}
	}
	static void adminPrintData() {
		while(true) {	

			if(data.isEmpty()) {											//	유효성 : 출력하려는데 상품이 없음.
				System.out.println("출력할 상품이 없습니다. \n");
				break;
			}
			for(Product v : data) {											//	.toString() 메서드를 재정의
				System.out.println(v);
			}	
			break;															//	상품 목록 출력 하고 while문 탈출.
		}
	}
	static int adminAddData() {
		while(true) {	
			System.out.print("상품의 이름을 입력 하세요 >> ");
			String name = sc.next();												//	사용자로부터 입력을 받기 위한 지역 변수
			System.out.println("입력한 이름이 정말 맞습니까 ? ");
			System.out.print("맞으면 1번, 아니면 2번 >> (뒤로가기 : 3) ");
			int check = sc.nextInt();												//	사용자로부터 입력을 받기 위한 지역 변수
			sc.nextLine();

			if(check == 1) {
				while(true) {	
					System.out.print("상품의 가격을 입력 하세요 >> ");	
					int price = sc.nextInt();										//	사용자로부터 입력을 받기 위한 지역 변수
					sc.nextLine();

					if(price < 0) {
						System.out.println("상품의 가격은 0원 이상 이어야 합니다. \n");
						continue;
					}
					while(true) {	
						System.out.print("상품의 재고를 입력 하세요 >> ");
						int stock = sc.nextInt();
						sc.nextLine();

						if(stock < 0) {
							System.out.println("재고의 개수는 0개 이상 이어야 합니다. \n");
							continue;
						}
						data.add(new Product(numPK++,name,price,stock));
						break;
					}
					break;
				}
			}
			else if(check == 2) {
				System.out.println("이름을 다시 입력 해주세요. \n");
				continue;
			}
			else if(check == 3) {
				System.out.println("상품을 만들지 않고, 관리자 모드로 돌아갑니다. \n");
			}
			else {
				System.out.println("유효하지 않는 번호 입니다. (1 ~ 3) \n");
				continue;
			}
			break;
		}	
		return numPK;
	}
	
	
	public static void main(String[] args) {
		mainMenu();
	}	//	main

}	//	main class
