data <- read.delim("CH01PR21.txt", sep = ",", header = FALSE)
x_axis <- c(data[1:nrow(data), 2]) # nolint
y_axis <- c(data[1:nrow(data), 1]) # nolint

lm(y_axis ~ x_axis, data = data.frame(x_axis, y_axis))

regression <- function(x) {
    return(4 * x + 10.2)
}

regression2 <- function(x) {
    4 * x + 10.2
}

sxx <- sum((x_axis - mean(x_axis))^2)
W_value <- sqrt(2 * qf(0.95, 2, length(x_axis) - 2, lower.tail = TRUE))
mse <- sum((y_axis - (x_axis * 4 + 10.2))^2) / (length(y_axis) - 2)

standard_dev <- function(x_value, n) {
    return(sqrt(mse * ((1 / n) + (((x_value - mean(x_axis))^2) / sxx))))
}

c(regression(0) - W_value * standard_dev(0, length(x_axis)), regression(0) + W_value * standard_dev(0, length(x_axis)))
c(regression(1) - W_value * standard_dev(1, length(x_axis)), regression(1) + W_value * standard_dev(1, length(x_axis)))
c(regression(2) - W_value * standard_dev(2, length(x_axis)), regression(2) + W_value * standard_dev(2, length(x_axis)))

qt(1 - 0.05 / (2 * 3), 8, lower.tail = TRUE)
W_value

standard_dev_pred <- function(x_value, n) {
    return(sqrt(mse * (1 + (1 / n) + (((x_value - mean(x_axis))^2) / sxx))))
}

c(regression(0) - sqrt(3 * qf(0.95, 3, 8)) * standard_dev_pred(0, length(x_axis)), regression(0) + sqrt(3 * qf(0.95, 3, 8)) * standard_dev_pred(0, length(x_axis)))
c(regression(1) - sqrt(3 * qf(0.95, 3, 8)) * standard_dev_pred(1, length(x_axis)), regression(1) + sqrt(3 * qf(0.95, 3, 8)) * standard_dev_pred(1, length(x_axis)))
c(regression(2) - sqrt(3 * qf(0.95, 3, 8)) * standard_dev_pred(2, length(x_axis)), regression(2) + sqrt(3 * qf(0.95, 3, 8)) * standard_dev_pred(2, length(x_axis)))

sqrt(3 * qf(0.95, 3, 8))
qt(1 - 0.05 / 6, 8)

mse
