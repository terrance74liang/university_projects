data <- read.table("Q3 A4.txt")
x <- matrix(c(rep(1, nrow(data)), unlist(data[c("V2", "V3", "V4", "V5")])), ncol = 5)
y <- matrix(data[, 1], ncol = 1)

inverse_xTx <- solve(t(x) %*% x)
b <- inverse_xTx %*% (t(x) %*% y)
y_hat <- x %*% b

mse <- (1 / (nrow(data) - 5)) * (t(y) %*% y - t(b) %*% t(x) %*% y)

Bonferoni_bounds <- qt(1 - (0.05 / (2 * 4)), nrow(data) - 5)
Working_hotelling_bounds <- sqrt(5 * qf(1 - 0.05, 5, nrow(data) - 5, lower.tail = TRUE))

Bonferoni_bounds
Working_hotelling_bounds

xh1 <- matrix(c(1, 5, 8.25, 0, 250000))
xh2 <- matrix(c(1, 6, 8.50, 0.23, 270000))
xh3 <- matrix(c(1, 14, 11.50, 0.11, 300000))
xh4 <- matrix(c(1, 12, 10.25, 0, 310000))

s2_yh1 <- mse * (t(xh1) %*% inverse_xTx %*% xh1)
s2_yh2 <- mse * (t(xh2) %*% inverse_xTx %*% xh2)
s2_yh3 <- mse * (t(xh3) %*% inverse_xTx %*% xh3)
s2_yh4 <- mse * (t(xh4) %*% inverse_xTx %*% xh4)

yh1 <- t(xh1) %*% b
yh2 <- t(xh2) %*% b
yh3 <- t(xh3) %*% b
yh4 <- t(xh4) %*% b

bounds <- function(y, con, s2) {
    print(c(y[1, 1] - con * sqrt(s2), y[1, 1] + con * sqrt(s2)))
}

bounds(yh1, Bonferoni_bounds, s2_yh1)
bounds(yh2, Bonferoni_bounds, s2_yh2)
bounds(yh3, Bonferoni_bounds, s2_yh3)
bounds(yh4, Bonferoni_bounds, s2_yh4)
