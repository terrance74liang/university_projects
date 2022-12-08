data <- read.table("Q4.txt", header = FALSE)
x_axis <- c(data[1:nrow(data), 2]) # nolint
y_axis <- c(data[1:nrow(data), 1]) # nolint

sxy <- sum(x_axis * y_axis)
sx <- sum(x_axis^2)

b1 <- sxy / sx
b1

transformed_y <- x_axis * b1

residuals <- sum((y_axis - transformed_y)^2)
sb1 <- sqrt((residuals / 44) / sx)
c(b1 - qt(1 - (0.1 / 2), 44) * sb1, b1 + qt(1 - (0.1 / 2), 44) * sb1)
spred_new <- sqrt((residuals / 44) * (1 + ((6^2) / sx)))
c(6 * b1 - qt(1 - (0.1 / 2), 44) * spred_new, 6 * b1 + qt(1 - (0.1 / 2), 44) *
    spred_new)
