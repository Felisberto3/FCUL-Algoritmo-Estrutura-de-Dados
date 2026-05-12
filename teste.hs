maior :: (Num a, Ord a) => [a] -> Int
maior list = aux list 0
  where
    aux [] acc = acc
    aux [_] acc = acc
    aux (x : y : xs) acc
      | x < y = aux (y : xs) (acc + 1)
      | otherwise = aux (y : xs) acc

maior2 :: (Num a, Ord a) => [a] -> Int
maior2 [] = 0
maior2 (k : xs) = snd $ foldl (\(y, n) x -> if y < x then (x, n + 1) else (x, n)) (k, 0) xs

func :: (Ord a, Num a) => [a] -> Int
func list = foldl (\acc (p, n) -> if p < n then acc + 1 else acc) 0 pair
  where
    l1 = init list
    l2 = tail list
    pair = zip l1 l2

quickSort :: (Ord a) => [a] -> [a]
quickSort [] = []
quickSort (x : xs) =
  let smallThen = quickSort [a | a <- xs, a <= x]
      greatherThen = quickSort [a | a <- xs, a > x]
   in smallThen ++ [x] ++ greatherThen

data Pessoa = Pessoa {nome :: String, idade :: Int}

funcP = Pessoa "felisberto" 23
