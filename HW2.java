import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: B0444109 林奕銜
 * 1.用getSuit、getRank來製作printcard() 讓這個method可以印出卡片的花色+數值
 * 2.要把卡片加入名為cards的Arraylist中，利用三個for迴圈讓(ndeck)副卡片都能執行cards.add()-->把元素塞進Arraylist
 * 3.用printcard()來製作printdeck，利用for迴圈(次數為Arraylist存放元素數)依序把Arraylist中的元素取出暫存於變數c
 * ，再讓c使用printcard()即可印出元素之花色+數值
 * Try to write some comments for your codes (methods, 15 points)
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards �������
	 * @param nDeck 蝮賢��嗾����
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: please add description here
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		for(int x=1;x<= nDeck;x++) {
			for(int y=1;y<=4;y++) {
				for(int z=1;z<=13;z++) {
					Card c = new Card(y,z);
					cards.add(c); 
				}
			}
		}

	}
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		for(int i = 0;i < cards.size();i++) 
		{
			Card c = cards.get(i);
			c.printCard();
		}

	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: please add description here
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace	
				System.out.println(getSuit()+","+getRank());
		}

	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
