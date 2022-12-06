module Lib ( processFile ) where

import Data.List.Split(splitOn)

processFile :: String -> (String -> IO ()) -> IO ()
processFile filename processor = do
    content <- readFile filename
    processor content

lines :: String -> Int
lines buffer = splitOn buffer "\n" 

divideInTriplets :: [String] -> [(String,String,String)]
divideInTriplets [] = []
divideInTriplets (x:y:z:xs) = (x,y,z) : divideInTriplets xs