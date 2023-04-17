package org.example.app.controllers;

import org.example.app.services.UserReadService;
import org.example.app.utils.AppStarter;
import org.example.app.views.UserReadView;


public class UserReadController {

    UserReadService service;
    UserReadView view;

    public UserReadController(UserReadService service, UserReadView view) {
        this.service = service;
        this.view = view;
    }

    public void readUsers() {
        // Передаем запрос на получение данных,
        // получаем ответ, отдаем на вывод.
        view.getOutput(service.readUsers());
        // Перезапускаем приложение.
        AppStarter.startApp();
    }
}
