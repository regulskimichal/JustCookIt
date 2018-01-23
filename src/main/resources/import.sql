insert into "user" (id, username, password, email, name, last_name, premium) values
    (1, 'qwaler', '$2a$10$mLryICQkOJBucbYXUtw58efpudGZt.FuPu3VQKLaD9R6qMdyRz6rO', 'qwalers@gmail.com', 'Michał',
     'Regulski', false);

insert into "category" (id, name, parent_id) values
    (1, 'Śniadania', null),
    (2, 'Zupy', null),
    (3, 'Dania główne', null),
    (4, 'Przekąski', null),
    (5, 'Dania mięsne', null),
    (6, 'Dania wege', null);

insert into "recipe" (id, description, name, notice, user_id) values
    (1, 'Smaczne, szybkie danie', 'Bruschetta z marynowanymi pomidorami', '', null);

