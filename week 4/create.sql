create table users (
    id int auto_increment NOT NULL,
    email varchar(128) NOT NULL,
    password varchar(128) NOT NULL,
    name varchar(128) NOT NULL default ' ',
    enabled boolean NOT NULL default true,
    role varchar(16) NOT NULL default 'USER',
    PRIMARY KEY (id),
    UNIQUE INDEX email_unique (`email` ASC)
) engine=InnoDB;

create table places (
    id integer not null auto_increment,
    address varchar(255) not null,
    image varchar(255) not null,
    phone varchar(255) not null,
    primary key (id)
) engine=InnoDB;

create table food_type (
    id integer not null auto_increment,
    name varchar(255) not null,
    primary key (id)
) engine=InnoDB;

create table units (
    id   int auto_increment primary key,
    name varchar(255) not null
) engine=InnoDB;

create table foods
(   id           int auto_increment primary key,
    description  varchar(300)   not null,
    image        varchar(255)   not null,
    name         varchar(255)   not null,
    portion      int            not null,
    price        double         not null,
    food_type_id int            not null,
    place_id     int            not null,
    unit_id      int            not null
) engine=InnoDB;

create table carts (
    id int auto_increment primary key,
    user_id int null,
    constraint FK_carts_users
        foreign key (user_id) references users (id)
) engine=InnoDB;

create table cart_food (
    id int auto_increment primary key,
    qty int null,
    price double null,
    cart_id int null,
    food_id int null,
    constraint FK_cart_food_foods
        foreign key (food_id) references foods (id),
    constraint FK_cart_food_carts
        foreign key (cart_id) references carts (id)
) engine=InnoDB;

alter table foods
    add constraint FK_foods_place
        foreign key (place_id)
            references places (id);

alter table foods
    add constraint FK_foods_food_type
        foreign key (food_type_id)
            references food_type (id);

alter table foods
    add constraint FK_foods_unit
        foreign key (unit_id)
            references units (id);

-----Add food type
            
INSERT INTO food_type (name) VALUE ('?????????????? ??????????'),
    ('???????????????? ??????????'),
    ('????????????'),
    ('????????????'),
    ('??????????????'),
    ('??????????????');

-----Add place
    
INSERT INTO places (address, image, phone) VALUES
('????. ?????????? ???????? 555', 'https://www.faiza.kg/media/info/gallery/about-us-banner_vnzHtUh.jpg', '+996555324921'),
('????. ???????????????? 159', 'https://www.faiza.kg/media/info/gallery/about-us-banner_vnzHtUh.jpg', '+996555324922');

-----Add unit

INSERT INTO units (name) VALUE ('????'),
    ('????'),
    ('????'),
    ('??');

----Add food
    
INSERT INTO foods
(description, image, name, portion, price, place_id, food_type_id, unit_id)
VALUES
('?????????? ???????????????? ???????????????????????? ???????????? ???????????? ?????????????? ?????????????????????? ????????. ?????????????????? ???? ?????????? ???????????????????????? ???????? ?? ???????? ?? ?????????? ?????????????????????? ??????????. ?????????????????? ???? ????????.',
'https://www.faiza.kg/media/menu/dishes/IMG_4299.jpg',
'??????????',
5,
170,
(SELECT id FROM places WHERE id=1),
(SELECT id FROM food_type WHERE id=2),
(SELECT id FROM units WHERE id=1)),
('?????????? ?????????????????? ?? ???????????????????? ??????????, ?????????????? ?????????????????? ???? ???????????? ?????????????????? ??????????????, ???? ?????????? ?????????????? ???????????????????? ???????????????? ??????????-????, ?????????????? ?????????????? ?? ??????????????????????. ?????????????????? ???? ???????????????? ?? ??????????-???????????? ?????????????? ????????????. ???????????????? ?? ???????????????? ????????.',
'https://www.faiza.kg/media/menu/dishes/IMG_4329.jpg',
'??????????-????',
250,
130,
(SELECT id FROM places WHERE id=1),
(SELECT id FROM food_type WHERE id=2),
(SELECT id FROM units WHERE id=1)),
('?????????? ???????????????????? ??????????, ?????????????? ?????????????? ?????????? ???? ???????????? ???????????????????? ????????, ???? ?? ?????????? ???????????? ????????????????. ?????????????????? ???? ???????????????? ????????????, ?????? ?? ????????, ???????????????????? ???????????????? ?? ???????????????????????? ??????????????????. ?????????????? ?????????????? ?? ???????????? ???????????? ???????? ?????????? ????????????????????.',
'https://www.faiza.kg/media/menu/dishes/IMG_4203.jpg',
'?????????? "????????????"',
150,
80,
(SELECT id FROM places WHERE id=1),
(SELECT id FROM food_type WHERE id=2),
(SELECT id FROM units WHERE id=1)),
('?????????????????? ???????????? ?????????? ????????????????????, ?????????????????? ?? ?????????????????????????????? ??????????, ?????????????? ???????????? ?????????????? ?? ?????????? ???????????? ??????????????. ?????????????????? ???? ?????????????????????????? ?????????????? ???????????????? ????????, ???????????????????????????? ??????????????????????????????. ?????????????? ???? ?????????? ?? ???????????????? ???? ???????????? ???????????????????? ??????????.',
'https://www.faiza.kg/media/menu/dishes/DSC_0747.jpg',
'???????????? ???? ????????????',
120,
80,
(SELECT id FROM places WHERE id=1),
(SELECT id FROM food_type WHERE id=2),
(SELECT id FROM units WHERE id=1)),
('?????????????????? ???????????????????? ???? ?????????????? ???? ?????????????????? ??????????????.',
'https://www.faiza.kg/media/menu/dishes/IMG_4403.jpg',
'?????????????????? ??????',
170,
60,
(SELECT id FROM places WHERE id=1),
(SELECT id FROM food_type WHERE id=2),
(SELECT id FROM units WHERE id=1)),
('??????????????, ?????????????? ??????????????, ???????????????????? ???????????????????????? ???????????????? ?? ????????????. ???????????????????????? ???? ???????????????????? ???????????????? ?????????? ???????????????? ????????????????. ???????????????? ???? ????????????????.',
'https://www.faiza.kg/media/menu/dishes/IMG_4450.jpg',
'???????? ???? ????????????????',
150,
30,
(SELECT id FROM places WHERE id=1),
(SELECT id FROM food_type WHERE id=2),
(SELECT id FROM units WHERE id=1));

-----Add User

INSERT INTO users
(email,
password,
name,
enabled,
role)
VALUES
('1@mail.ru', 'mickmick', 'mick', 1, 'USER');

----Add carts
INSERT INTO carts
(user_id)
VALUES (1);

-----Add cart food

INSERT INTO cart_food
(qty, price, cart_id, food_id)
VALUES (3, (SELECT price FROM foods WHERE id=1), 1, 1);

