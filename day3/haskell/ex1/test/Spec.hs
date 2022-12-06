-- main :: IO ()
-- main = putStrLn "Test suite not yet implemented"
module Main(main) where

import Test.Hspec
import Lib 

main :: IO ()
main = hspec $ do
 describe "mmm" $ do
  it "process file" $ do
    processFile "test.txt" head `shouldBe` "vJrwpWtwJgWrhcsFMMfFFhFp"
