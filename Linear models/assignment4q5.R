x <- matrix(c(rep(1, 6), 7, 4, 16, 3, 21, 8, 33, 41, 7, 49, 5, 31), ncol = 3)
y <- matrix(c(42, 33, 75, 28, 91, 55), ncol = 1)

inverse_xTx <- solve(t(x) %*% x)
b <- inverse_xTx %*% t(x) %*% y
b

e <- y - x %*% b
e

H <- x %*% inverse_xTx %*% t(x)
H

j <- matrix(rep(1, nrow(x)^2), ncol = nrow(x))
ssr <- t(y) %*% (H - ((1 / nrow(x)) * j)) %*% y
ssr

sse <- t(y) %*% y - t(b) %*% t(x) %*% y
sse

mse <- sse / (nrow(x) - ncol(x))
mse

s2b <- mse[1, 1] * inverse_xTx
s2b

xh <- matrix(c(1, 10, 30), ncol = 1)
yhath <- t(xh) %*% b
yhath

s2yh <- t(xh) %*% s2b %*% xh
s2yh
