package data;

public enum Locators {
	
	USER_NAME("zekov.roman78"),
	PASSWORD("Nthvbyfnjh"),
	/*-------------------------------------------------------------------*/
	PASSWD_INPUT("Passwd"),
	SIGN_IN_BUTTON("signIn"),
	PERSISTENT_COOKIE("PersistentCookie"),
	/*-------------------------------------------------------------------*/
	/*-------------------------------------------------------------------*/
	/*-------------------------------------------------------------------*/	
	/*-------------------------------------------------------------------*/
	/*-------------------------------------------------------------------*/
	/*-------------------------------------------------------------------*/	
	COMPOSE_NEW_MAIL("T-I-KE"),
	SEND_EMAIL("//div[@class='T-I J-J5-Ji aoO T-I-atl L3']"),
	EMAIL("//span[@email='zekov.roman78@gmail.com']"),
	BODY("//span[@class='y2']"),
	RECEIVER_INPUT("//textarea[@aria-label='Кому']"), //Komu
	SUBJECT_INPUT("aoT"),
	BODY_INPUT("//div[@aria-label='Тело письма']"),
	DELETE_EMAIL_BUTTON("//div[@data-tooltip='Удалить']"), //Udalit
/*-------------------------------------------------------------------*/	
	GOOGLE_SIGN_IN("gb_70"),
	GMAIL_LINK("//a[@id='gb23']"), //   .//*[@id='gb23']/span[1]
	GOOGLE_APPS_MENU(".//*[@id='gbwa']/div[1]/a"),
	NAME_LABEL(".gb_P.gb_R"),
	CONFIRMATION_BUTTON("//a[@title='No thanks']"),
/*-------------------------------------------------------------------*/
	LOGIN_INPUT("Email"),
	LOGIN_NEXT_BUTTON("next");
	
	
	private final String value;
	
	Locators (String value) {
        
		this.value = value;
        
    }
	
	public String getValue() { return value; }


}
