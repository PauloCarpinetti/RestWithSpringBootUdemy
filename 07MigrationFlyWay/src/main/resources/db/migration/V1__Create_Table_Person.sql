CREATE TABLE IF NOT EXISTS `pessoa` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `endereco` varchar(100) DEFAULT NULL,
  `genero` varchar(9) DEFAULT NULL,
  `primeiro_nome` varchar(100) NOT NULL,
  `ultimo_nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
  )