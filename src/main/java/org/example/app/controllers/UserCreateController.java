package org.example.app.controllers;

import org.example.app.services.UserCreateService;
import org.example.app.utils.AppStarter;
import org.example.app.views.UserCreateView;

public class UserCreateController {

    UserCreateView view;
    UserCreateService service;

    public UserCreateController(UserCreateService service, UserCreateView view) {
        this.service = service;
        this.view = view;
    }

    public void createUser() {
        // Получаем входные данные.
        // Передаем данные на обработку, получаем результат.
        // Выводим результат.
        view.getOutput(service.createUser(view.getData()));
        // Перезапускаем приложение.
        AppStarter.startApp();
    }
}
