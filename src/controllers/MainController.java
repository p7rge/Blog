package controllers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import views.MenuList;
import models.*;

public class MainController {
	
	public static void main(String[] args) {
		UserFactory userFactory = new UserFactory();
		
		
		MenuList menuList = new MenuList();
		menuList.mainMenu();
		
		Scanner mainMenuScanner = new Scanner(System.in);
		
		int options = mainMenuScanner.nextInt();
		boolean exitcode = false;
		
		while (exitcode != true) {
			switch (options) {
				case 1:
					HashMap<String, String> newUserData = new HashMap<String, String>();
					newUserData = menuList.registerView();
					
					String newUserUsername = newUserData.get("username");
					String newUserPassword = newUserData.get("password");
					
					User newUser = new User(newUserUsername, newUserPassword);
					userFactory.addUser(newUser);
					
					menuList.mainMenu();
					
					options = mainMenuScanner.nextInt();
					break;
				case 2:
					HashMap<String, String> userLoginData = new HashMap<String, String>();
					userLoginData = menuList.loginView();
					
					String usernameLogin = userLoginData.get("username");
					String passwordLogin = userLoginData.get("password");
					
					User activeUser = userFactory.verifyLogin(usernameLogin, passwordLogin);
					
					if (activeUser != null) {
						menuList.successLoginMessage();
						menuList.blogMenu();
						
						int optionsBlogMenu = mainMenuScanner.nextInt();
						boolean logoutcode = false;
						
						while (logoutcode == false && exitcode == false) {
							switch(optionsBlogMenu) {
								case 1:
									HashMap<String, String> newArticle = new HashMap<String,String>();
									newArticle = menuList.addNewArticleView();
									
									String title = newArticle.get("title");
									String body = newArticle.get("body");
									
									Article article = new Article(title, body);
									activeUser.addArticle(article);
									menuList.blogMenu();
									optionsBlogMenu = mainMenuScanner.nextInt();
									break;
								case 2:
									ArrayList<Article> activeUserArticles = new ArrayList<Article>();
									activeUserArticles = activeUser.getArticleList();
									menuList.listUserArticle(activeUserArticles);									
									menuList.blogMenu();
									optionsBlogMenu = mainMenuScanner.nextInt();
									break;
								case 9:
									logoutcode = true;
									menuList.mainMenu();
									options = mainMenuScanner.nextInt();
									break;
								case 0:
									menuList.exitMessage();
									exitcode = true;
									break;
								default:
									menuList.errorMessage();
									exitcode = true;
									break;
							}							
						}
						
					} else {
						menuList.errorLoginMessage();
						menuList.mainMenu();
						options = mainMenuScanner.nextInt();
					}
					break;
				case 0:
					menuList.exitMessage();
					exitcode = true;
					break;
				default:
					exitcode = true;
					menuList.errorMessage();
					break;				
			}			
		}

	}
}
