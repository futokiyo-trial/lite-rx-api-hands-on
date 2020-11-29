package io.pivotal.literx;

import io.pivotal.literx.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Learn how to merge flux.
 *
 * @author Sebastien Deleuze
 */
public class Part05Merge {

//========================================================================================

	// TODO Merge flux1 and flux2 values with interleave
	Flux<User> mergeFluxWithInterleave(Flux<User> flux1, Flux<User> flux2) {
		// flux1で遅延処理が入っている。
		// mergeWithは遅延処理の入っていないflux2が先勝ちでflux1のストリームから通知される。
		return flux1.mergeWith(flux2);
	}

//========================================================================================

	// TODO Merge flux1 and flux2 values with no interleave (flux1 values and then flux2 values)
	Flux<User> mergeFluxWithNoInterleave(Flux<User> flux1, Flux<User> flux2) {
		// flux1で遅延処理が入っている。
		// concatWithはflux1の要素を通知してから、継いでflux2の要素をStreamに通知する。
		return flux1.concatWith(flux2);
	}

//========================================================================================

	// TODO Create a Flux containing the value of mono1 then the value of mono2
	Flux<User> createFluxFromMultipleMono(Mono<User> mono1, Mono<User> mono2) {

		return Flux.concat(mono1, mono2);
	}

}
