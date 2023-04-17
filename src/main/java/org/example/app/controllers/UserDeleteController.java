package org.example.app.controllers;

import org.example.app.services.UserDeleteService;
import org.example.app.utils.AppStarter;
import org.example.app.views.UserDeleteView;

public class UserDeleteController {

    UserDeleteService service;
    UserDeleteView view;

    public UserDeleteController(UserDeleteService service, UserDeleteView view) {
        this.service = service;
        this.view = view;
    }

    public void deleteUser() {
        // Получаем входные данные.
        // Передаем данные на обработку, получаем результат.
        // Выводим результат.
        view.getOutput(service.deleteUser(view.getData()));
        // Перезапускаем приложение.
        AppStarter.startApp();
    }
}
