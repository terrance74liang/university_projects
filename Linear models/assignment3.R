suppressMessages(library("tidyverse"))
x <- c(4.5, 4.5, 4.5, 4.0, 4.0, 4.0, 5.0, 5.0, 5.5, 5.0, 0.5, 0.5, 6.0, 6.0, 1.0, 1.0, 1.0)
y <- c(619, 1049, 1033, 495, 723, 681, 890, 1522, 987, 1194, 163, 182, 764, 1373, 978, 465, 550)



group_data <- data.frame(x = x, y = y)
plot(x, y, main = "y values against x values")
abline(lm(y ~ x, data = group_data))
y_trans <- predict(lm(y ~ x, data = group_data))
group_data$ytrans <- y_trans
group_data <- arrange(group_data, x)

x_0.5 <- colMeans(group_data[1:2, ])
x_1.0 <- colMeans(group_data[3:5, ])
x_4.0 <- colMeans(group_data[6:8, ])
x_4.5 <- colMeans(group_data[9:11, ])
x_5.0 <- colMeans(group_data[12:14, ])
x_5.5 <- colMeans(group_data[15, ])
x_6.0 <- colMeans(group_data[16:17, ])

sspe <- sum(c(
    (group_data[group_data$x == 0.5, 2] - x_0.5[2])^2,
    (group_data[group_data$x == 1, 2] - x_1.0[2])^2,
    (group_data[group_data$x == 4, 2] - x_4.0[2])^2,
    (group_data[group_data$x == 4.5, 2] - x_4.5[2])^2,
    (group_data[group_data$x == 5, 2] - x_5.0[2])^2,
    (group_data[group_data$x == 5.5, 2] - x_5.5[2])^2,
    (group_data[group_data$x == 6, 2] - x_6.0[2])^2
))

sslf <- sum(c(
    (x_0.5[2] - group_data[group_data$x == 0.5, 3])^2,
    (x_1.0[2] - group_data[group_data$x == 1, 3])^2,
    (x_4.0[2] - group_data[group_data$x == 4, 3])^2,
    (x_4.5[2] - group_data[group_data$x == 4.5, 3])^2,
    (x_5.0[2] - group_data[group_data$x == 5, 3])^2,
    (x_5.5[2] - group_data[group_data$x == 5.5, 3])^2,
    (x_6.0[2] - group_data[group_data$x == 6, 3])^2
))

MSPE <- sspe / (length(x) - 7)
MSLF <- sslf / (7 - 2)

F_crit <- MSLF / MSPE

F_crit <= qf(1 - 0.05, 7 - 2, length(x) - 7, lower.tail = TRUE)
F_crit > qf(1 - 0.05, 7 - 2, length(x) - 7, lower.tail = TRUE)

plot(x, residuals(lm(y ~ x, data = group_data)), main = "residuals against x values")

F_crit
MSPE
MSLF
lm(y ~ x, data = group_data)
qf(1 - 0.05, 7 - 2, length(x) - 7, lower.tail = TRUE)
