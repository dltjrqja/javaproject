     
 class Book {
	 private String title, authotr, publisher, Posts, Character; 
	  
	 
	 
	 private String getPublisher() {
		return publisher;
	}
	private void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	private String getPosts() {
		return Posts;
	}
	private void setPosts(String posts) {
		Posts = posts;
	}
	private String getCharacter() {
		return Character;
	}
	private void setCharacter(String character) {
		Character = character;
	}
	public String getTitle(){
		 return title;
	 }
	private String getAuthotr() {
		return authotr;
	}
	void setAuthotr(String authotr) {
		this.authotr = authotr;
	}
	private void setTitle(String title) {
		this.title = title;
	}
	
 }
	public class BookTest{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b= new Book();
		 b.setAuthotr("±èº¸°â");
		 b.title("¾î¸°¿ÕÀÚ");
	
		
	}
	}
 }
