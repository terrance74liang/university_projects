data <- read.table("Q2.txt")
x <- data[, 2]
y <- data[, 1]

X_matrix <- matrix(c(rep(1, length(x)), x), ncol = 2)
xTx <- t(X_matrix) %*% X_matrix
inverse_xTx <- solve(xTx)
print("(X^T X)^-1")
inverse_xTx

y <- matrix(y, ncol = 1)
b <- inverse_xTx %*% t(X_matrix) %*% y
print("b")
b


Y_hat <- X_matrix %*% b
print("yhat")
Y_hat

H <- X_matrix %*% inverse_xTx %*% t(X_matrix)
print("H")
H

sse <- t(y) %*% y - t(b) %*% t(X_matrix) %*% y
print("sse")
sse

mse <- (1 / (length(x) - 2)) * sse
s_two_b <- mse[1, 1] * inverse_xTx
print("mse")
mse
print("s2{b}")
s_two_b

xh <- matrix(c(1, 30), ncol = 1)
s_two_pred <- mse[1, 1] * (1 + t(xh) %*% inverse_xTx %*% xh)
print("s2{pred}")
s_two_pred

s_two_b0 <- s_two_b[1, 1]
s_two_b1 <- s_two_b[2, 2]
s_b0_b1 <- s_two_b[1, 2]

print("s2{b0}")
s_two_b0
print("s{b1}")

sqrt(s_two_b1)
print("s{b0,b1}")

s_b0_b1


A <- diag(length(H[, 1])) - H
sse_quad <- t(y) %*% A %*% y
print("quadratic matrix")
A
sse_quad
