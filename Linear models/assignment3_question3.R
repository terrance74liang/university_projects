suppressMessages(library("tidyverse"))
data <- read.delim("Q3mod.txt", header = TRUE)
x <- c(data[1:nrow(data), 2]) # nolint
y <- c(data[1:nrow(data), 1]) # nolint

plot(x, y)
group_data <- data.frame(x = x, y = y)
y_trans <- predict(lm(y ~ x, data = group_data))
group_data$ytrans <- y_trans
group_data
group_data <- arrange(group_data, x)
x_16 <- colMeans(group_data[1:4, ])
x_24 <- colMeans(group_data[5:8, ])
x_32 <- colMeans(group_data[9:12, ])
x_40 <- colMeans(group_data[13:16, ])

sspe <- sum(c(
    (group_data[group_data$x == 16, 2] - x_16[2])^2,
    (group_data[group_data$x == 24, 2] - x_24[2])^2,
    (group_data[group_data$x == 32, 2] - x_32[2])^2,
    (group_data[group_data$x == 40, 2] - x_40[2])^2
))

sslf <- sum(c(
    (x_16[2] - group_data[group_data$x == 16, 3])^2,
    (x_24[2] - group_data[group_data$x == 24, 3])^2,
    (x_32[2] - group_data[group_data$x == 32, 3])^2,
    (x_40[2] - group_data[group_data$x == 40, 3])^2
))

MSPE <- sspe / (length(x) - 4)
MSLF <- sslf / (4 - 2)

F_crit <- MSLF / MSPE

F_crit <= qf(1 - 0.01, 4 - 2, length(x) - 4, lower.tail = TRUE)
F_crit > qf(1 - 0.01, 4 - 2, length(x) - 4, lower.tail = TRUE)

lm(y ~ x, data = group_data)
qf(1 - 0.01, 4 - 2, length(x) - 4, lower.tail = TRUE)
sspe
sslf
F_crit
