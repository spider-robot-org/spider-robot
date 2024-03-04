// console.log(JSON.stringify(
// 	{
// 		"chat_id": chatId,
// 		"message_id": messageId
// 	}
// ))

(async () => {
	const chatId = 6131615671;
	const messageId = 244;

	// Deleta a mensagem
	const res1 = await fetch("https://api.telegram.org/bot6886962771:AAGU8Ikmi9OiuMN3LcqjYykSUlGdYtqIkF0/deleteMessage", {
		method: "POST",
		body: JSON.stringify(
			{
				"chat_id": chatId,
				"message_id": messageId + 1
			}
		)
	});

	// Envia uma mensagem
	const res2 = await fetch("https://api.telegram.org/bot6886962771:AAGU8Ikmi9OiuMN3LcqjYykSUlGdYtqIkF0/sendMessage", {
		method: "POST",
		body: JSON.stringify(
			{
				"chat_id": chatId,
				"text": "Novas opções",
				"reply_markup": {
					"inline_keyboard": [
						[
							{
								"text": "Oi",
								"callback_data": "opt2"
							}
						]
					]
				}
			}
		)
	});

	console.log(await res1.json());
	console.log(await res2.json());
})().catch(console.error);