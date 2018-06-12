package views;

import java.util.HashMap;
import java.util.Scanner;

import models.Article;

import java.util.ArrayList;

public class MenuList {
	
	public static void mainMenu () {
		
		MenuList menuList = new MenuList();
		
		System.out.println("Selamat Datang di Blog Sederhana");
		System.out.println("1. Registrasi");
		System.out.println("2. Login");
		System.out.println("0. Keluar");
		menuList.brView();
	
	}
	
	public static HashMap<String,String> registerView () {
		
		MenuList menuList = new MenuList();
		HashMap<String, String> newUser = new HashMap<String, String>();
		Scanner registerViewScanner = new Scanner(System.in);
		
		System.out.println("Masukkan username untuk akun baru anda : ");
		String newUsername = registerViewScanner.nextLine();
		System.out.println("Masukkan password untuk akun baru anda : ");
		String newPassword = registerViewScanner.nextLine();
		
		newUser.put("username", newUsername);
		newUser.put("password", newPassword);
		
		menuList.brView();		
		return newUser;
	}
	
	public static HashMap<String, String> loginView () {
		
		MenuList menuList = new MenuList();
		HashMap<String, String> userLoginData = new HashMap<String, String>();
		
		Scanner loginViewScanner = new Scanner(System.in);
		
		System.out.println("Username : ");
		String usernameLogin = loginViewScanner.nextLine();
		System.out.println("Password for " + usernameLogin + " : " );
		String passwordLogin = loginViewScanner.nextLine();
		
		userLoginData.put("username", usernameLogin);
		userLoginData.put("password", passwordLogin);
		
		menuList.brView();
		
		return userLoginData;
		
	}
	
	public static void blogMenu () {
		
		MenuList menuList = new MenuList();
		
		System.out.println("Selamat datang di halaman blog anda : ");
		System.out.println("1. Tambah Article.");
		System.out.println("2. Lihat Article.");
		System.out.println("9. Logout");
		System.out.println("0. Keluar");
		menuList.brView();
		
	}
	
	public static HashMap<String, String> addNewArticleView() {
		
		HashMap<String, String> newArticle = new HashMap<String, String>();
		Scanner addNewArticleScanner = new Scanner(System.in);
		
		System.out.println("(*) Masukkan judul artikel anda : ");
		String newArticleTitle = addNewArticleScanner.nextLine();
		System.out.println("(*) Masukkan isi artikel anda : ");
		String newArticleBody = addNewArticleScanner.nextLine();
		
		newArticle.put("title", newArticleTitle);
		newArticle.put("body", newArticleBody);
		
		return newArticle;
	}
	
	public static void listUserArticle (ArrayList<Article> articles) {
		for(Article activeUserArticle : articles) {
			System.out.println(activeUserArticle.getTitle());
			System.out.println(activeUserArticle.getBody());
			System.out.println("===========================");
		}
	}
	
	public static void successLoginMessage () {
		System.out.println("Login Success !");
	}
	
	public static void errorLoginMessage () {
		System.out.println("Login Failed !");
	}
	
	public static void errorMessage () {
		System.out.println("No specific command found, system is now terminating..");
	}
	
	public static void brView () {
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	public static void exitMessage () {
		System.out.println("Anda keluar dari system, bye..");
	}
	
}
