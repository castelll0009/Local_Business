package com.example.menusdenavegacion.ui.login;

public class informacionGlobal {
    public static  boolean SESION = false;

    public  void   setSesion(boolean parametro){
        if(parametro == true){
            SESION = true;
        }else{
            SESION = false;
        }
    }
}
