module Main (main) where

import Lib

main :: IO ()
main = processFile "input.txt" (putStr)
