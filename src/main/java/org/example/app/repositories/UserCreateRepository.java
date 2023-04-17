package org.example.app.repositories;

import org.example.app.entities.User;
import org.example.app.utils.Constants;
import org.example.app.utils.HibernateUtil;
// Interface Session. Основной интерфейс времени выполнения между
// приложением Java и Hibernate. Представляет понятие контекста сохраняемости,
// набора экземпляров управляемых объектов, связанных с логической транзакцией.
//https://docs.jboss.org/hibernate/orm/6.2/javadocs/org/hibernate/Session.html
import org.hibernate.Session;
// Interface Transaction представляет локальную транзакцию ресурса,
// где локальная транзакция интерпретируется Hibernate как любая
// транзакция, находящаяся под управлением Hibernate.
// https://docs.jboss.org/hibernate/orm/6.2/javadocs/org/hibernate/Transaction.html
import org.hibernate.Transaction;
// Interface MutationQuery. В контексте активной session представляет
// исполняемый запрос на изменение, то есть insert, update, или delete.
// Это упрощенная версия Query, предоставляющая только методы, относящиеся
// к запросам на изменение.
// https://docs.jboss.org/hibernate/orm/6.2/javadocs/org/hibernate/query/MutationQuery.html
// https://docs.jboss.org/hibernate/orm/6.2/javadocs/org/hibernate/query/QueryProducer.html#createMutationQuery(java.lang.String)
import org.hibernate.query.MutationQuery;

public class UserCreateRepository {

    public String createUser(User user) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Транзакция стартует
            transaction = session.beginTransaction();

            String hql = "INSERT INTO User (firstName, lastName, nickName, phone, email) " +
                    "VALUES (:firstName, :lastName, :nickName, :phone, :email)";

            MutationQuery query = session.createMutationQuery(hql);
            query.setParameter("firstName", user.getFirstName());
            query.setParameter("lastName", user.getLastName());
            query.setParameter("nickName", user.getNickName());
            query.setParameter("phone", user.getPhone());
            query.setParameter("email", user.getEmail());
            query.executeUpdate();

            // Транзакция выполняется
            transaction.commit();
            return Constants.DATA_INSERT_MSG;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return e.getMessage();
        }
    }
}
