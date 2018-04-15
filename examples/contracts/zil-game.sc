(*
ZilGame contract implements the following game:

1. Two players, A and B submit hashes of some integer values without
   revealing the pre-images.

2. After the first player has submitted, the timer starts for the second
   one, so the submission can be only made within 5 (or so) blocks
   after the first one, to guarantee some fairness. The second
   submitted solution is rejected is he missed the deadline.

3. Each of the players can then try to claim their reward via the
   ClaimReward transition. The winner is determined based on how close
   the solution is to the puzzle (wee need distance on hashes).
   The players must submit their pre-images to claim the reward, and
   it must match. If the player who submitted second failed to submit,
   the winner is the first one automatically.
 
Question: what primitive should we have in the language to check the
current block number? Or should it be the previous block number? What
is reasonable here?

*)


(***************************************************)
(*               Associated library                *)
(***************************************************)
library ZilGame

(*  Here come definitions of auxiliary functions  *)


(***************************************************)
(*             The contract definition             *)
(***************************************************)
contract ZilGame 
  (player_a : address,
   player_b : address,
   puzzle   : hash)

(* Initial balance is not stated explicitly:   *)
(* it's initialized when creating the contract *)

field player_a_hash : option hash = None
field player_b_hash : option hash = None
field timer         : option (pair int bnum) = None
field game_over     : bool = False

transition Play

(* Players can submit their guesses *)

end

transition ClaimReward
(* 
Each player can try to reclaim their reward. This transition will
check eligibility, solution quality, and the hash pre-image submitted
(an integer value) and then will send the reward, ending the game
*)
end


