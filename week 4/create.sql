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
            
INSERT INTO food_type (name) VALUE ('Горячие блюда'),
    ('Холодные блюда'),
    ('Салаты'),
    ('Шашлык'),
    ('Гарниры'),
    ('Напитки');

-----Add place
    
INSERT INTO places (address, image, phone) VALUES
('пр. Жибек Жолу 555', 'https://www.faiza.kg/media/info/gallery/about-us-banner_vnzHtUh.jpg', '+996555324921'),
('ул. Медерова 159', 'https://www.faiza.kg/media/info/gallery/about-us-banner_vnzHtUh.jpg', '+996555324922');

-----Add unit

INSERT INTO units (name) VALUE ('гр'),
    ('шт'),
    ('мл'),
    ('л');

----Add food
    
INSERT INTO foods
(description, image, name, portion, price, place_id, food_type_id, unit_id)
VALUES
('Манты являются традиционным мясным блюдом народов Центральной Азии. Готовятся из мелко нарубленного мяса и лука в тонко раскатанном тесте. Готовятся на пару.',
'https://www.faiza.kg/media/menu/dishes/IMG_4299.jpg',
'Манты',
5,
170,
(SELECT id FROM places WHERE id=1),
(SELECT id FROM food_type WHERE id=2),
(SELECT id FROM units WHERE id=1)),
('Блюдо уйгурской и дунганской кухни, которое готовится во многих азиатских странах, но самым вкусным заслуженно признано ашлям-фу, которое готовят в Кыргызстане. Готовится из крахмала с остро-кислым овощным соусом. Подается в холодном виде.',
'https://www.faiza.kg/media/menu/dishes/IMG_4329.jpg',
'Ашлям-Фу',
250,
130,
(SELECT id FROM places WHERE id=1),
(SELECT id FROM food_type WHERE id=2),
(SELECT id FROM units WHERE id=1)),
('Очень популярный салат, который украсит собой не только новогодний стол, но и любое другое застолье. Готовится из отварных овощей, яиц и мяса, нарезанных кубиками и заправленных майонезом. Зеленый горошек и зелень делают вкус более насыщенным.',
'https://www.faiza.kg/media/menu/dishes/IMG_4203.jpg',
'Салат "Оливье"',
150,
80,
(SELECT id FROM places WHERE id=1),
(SELECT id FROM food_type WHERE id=2),
(SELECT id FROM units WHERE id=1)),
('Известное мясное блюдо кавказской, восточной и среднеазиатской кухни, которое уходит корнями в очень старые времена. Готовится из качественного свежего куриного мяса, предварительно замаринованного. Жарится на углях и подается со свежим нарезанным луком.',
'https://www.faiza.kg/media/menu/dishes/DSC_0747.jpg',
'Шашлык из курицы',
120,
80,
(SELECT id FROM places WHERE id=1),
(SELECT id FROM food_type WHERE id=2),
(SELECT id FROM units WHERE id=1)),
('Картофель обжаренный во фритюре до хрустящей корочки.',
'https://www.faiza.kg/media/menu/dishes/IMG_4403.jpg',
'Картофель фри',
170,
60,
(SELECT id FROM places WHERE id=1),
(SELECT id FROM food_type WHERE id=2),
(SELECT id FROM units WHERE id=1)),
('Вкусный, горячий напиток, обладающий неповторимым ароматом и вкусом. Заваривается из обжаренных кофейных зерен высокого качества. Подается со сливками.',
'https://www.faiza.kg/media/menu/dishes/IMG_4450.jpg',
'Кофе со сливками',
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

