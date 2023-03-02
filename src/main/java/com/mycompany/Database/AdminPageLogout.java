/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Database;

import com.mycompany.Admin.Page1_AdminLogin;
import javax.swing.JFrame;

/**
 *
 * @author JoeAlpha
 */
public class AdminPageLogout {
    public static void logMeOut(JFrame context, Page1_AdminLogin LoginScreen) {
        AdminCredentials.isloggedIn = false;
        context.setVisible(false);
        LoginScreen.setVisible(true);
    }
}
