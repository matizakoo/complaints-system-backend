CREATE TABLE IF NOT EXISTS `Role` (
                                      `id` BIGINT AUTO_INCREMENT,
                                      `name` VARCHAR(255) NOT NULL,
                                      PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `User` (
                                      `id` BIGINT AUTO_INCREMENT,
                                      `username` VARCHAR(255) NOT NULL UNIQUE,
                                      `password` VARCHAR(255) NOT NULL,
                                      PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `user_role` (
                                           `user_id` BIGINT,
                                           `role_id` BIGINT,
                                           PRIMARY KEY (`user_id`, `role_id`),
                                           FOREIGN KEY (`user_id`) REFERENCES `User`(`id`),
                                           FOREIGN KEY (`role_id`) REFERENCES `Role`(`id`)
);

CREATE TABLE IF NOT EXISTS `category` (
                          `id` INT AUTO_INCREMENT PRIMARY KEY,
                          `category` VARCHAR(255) UNIQUE NOT NULL
);