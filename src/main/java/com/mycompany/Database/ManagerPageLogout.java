/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Database;

import com.mycompany.Manager.Page1_ManagerLogin;
import javax.swing.JFrame;

/**
 *
 * @author JoeAlpha
 */
public class ManagerPageLogout {
    public static void logMeOut(JFrame context, Page1_ManagerLogin LoginScreen) {
        ManagerCredentials.isloggedIn = false;
        context.setVisible(false);
        LoginScreen.setVisible(true);
    }
}
