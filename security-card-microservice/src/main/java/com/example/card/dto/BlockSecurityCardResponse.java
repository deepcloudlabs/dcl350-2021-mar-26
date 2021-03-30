package com.example.card.dto;

public class BlockSecurityCardResponse {
	private String status;

	public BlockSecurityCardResponse(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "BlockSecurityCardResponse [status=" + status + "]";
	}

}
